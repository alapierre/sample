package pl.com.softproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.softproject.model.PersonFirst;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by admin01 on 29.10.14.
 */
@Repository
public class PersonFirstDaoImpl implements PersonFirstDao {

    @PersistenceContext(unitName="PersistenceUnitFirst")
    private EntityManager em;

    @Override
    @Transactional
    public void createPerson(PersonFirst person) {

        em.persist(person);

    }
}
