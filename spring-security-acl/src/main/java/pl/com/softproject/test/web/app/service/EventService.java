package pl.com.softproject.test.web.app.service;

import pl.com.softproject.test.web.app.model.Event;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @author Marcin Jasinski <mkjasinski@gmail.com>
 */
public interface EventService {

    public Event load(int id);

    public void add(Event event);

    public void edit(Event event);

    public void delete(Event event);

    public Iterable<Event> getAll();
}
