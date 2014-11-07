package pl.com.softproject.dao;

import pl.com.softproject.model.PersonSecond;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/**
 * Created by admin01 on 29.10.14.
 */
@Repository
public class PersonSecondDaoImpl implements PersonSecondDao {

    @PersistenceContext(unitName="PersistenceUnitSecond")
    private EntityManager em;

    @Override
    @Transactional
    public void createPerson(PersonSecond person, boolean throwException) {

        em.persist(person);

        if (throwException)
            throw new RuntimeException("There was problem during persist");
    }
}
