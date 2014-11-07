package pl.com.softproject.service;

import pl.com.softproject.dao.PersonFirstDao;
import pl.com.softproject.dao.PersonSecondDao;
import pl.com.softproject.model.PersonFirst;
import pl.com.softproject.model.PersonSecond;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by admin01 on 29.10.14.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private PersonFirstDao personfirstDao;

    @Autowired
    private PersonSecondDao personSecondDao;

    @Transactional
    public void savePersons() {

        PersonFirst person1 = new PersonFirst();
        person1.setName("Tomasz");
        person1.setSurname("Zamachowski");
        person1.setVersion(1);

        PersonSecond person2 = new PersonSecond();
        person2.setName("Andrzej");
        person2.setSurname("Kanecki");
        person2.setVersion(1);

        logger.debug("Persist first person");
        personfirstDao.createPerson(person1);

        logger.debug("Persist second person");
        try {
            personSecondDao.createPerson(person2, true);

        } catch (Exception e) {
            logger.error("", e);
        }

        logger.debug("Both persons persisted");
    }
}
