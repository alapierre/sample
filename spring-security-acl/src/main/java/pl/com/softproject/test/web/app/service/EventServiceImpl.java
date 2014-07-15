package pl.com.softproject.test.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.MutableAclService;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.softproject.test.web.app.dao.EventDAO;
import pl.com.softproject.test.web.app.model.Event;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @author Marcin Jasinski <mkjasinski@gmail.com>
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private MutableAclService mutableAclService;

    @Override
    @PostAuthorize("hasPermission(returnObject, read)")
    public Event load(int id) {

        return eventDAO.findOne(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public void add(Event event) {

        event = eventDAO.saveAndFlush(event);
        createAcl(event);
    }

    @Override
    @PostAuthorize("hasPermission(#event, write)")
    public void edit(Event event) {

        eventDAO.save(event);
    }

    @Override
    @PreAuthorize("hasPermission(#event, delete)")
    public void delete(Event event) {

        eventDAO.delete(event);
        deleteAcl(event);
    }

    @Override
    @PostFilter("hasPermission(filterObject, read)")
    public Iterable<Event> getAll() {

        return eventDAO.findAll();
    }

    private void createAcl(Event event) {

        Sid author = new PrincipalSid(SecurityContextHolder.getContext().getAuthentication().getName());

        Integer eventId = event.getId();
        ObjectIdentity objectIdentity = new ObjectIdentityImpl(Event.class, eventId);

        MutableAcl eventAcl = mutableAclService.createAcl(objectIdentity);
        eventAcl.insertAce(0, BasePermission.READ, author, true);
        eventAcl.insertAce(0, BasePermission.WRITE, author, true);
        eventAcl.insertAce(0, BasePermission.DELETE, author, true);

        eventAcl.setOwner(author);
        mutableAclService.updateAcl(eventAcl);
    }

    private void deleteAcl(Event event) {

        Integer eventId = event.getId();

        mutableAclService.deleteAcl(new ObjectIdentityImpl(Event.class, eventId), false);
    }
}
