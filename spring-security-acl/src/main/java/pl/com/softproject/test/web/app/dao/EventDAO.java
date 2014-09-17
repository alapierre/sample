package pl.com.softproject.test.web.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.softproject.test.web.app.model.Event;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @author Marcin Jasinski <mkjasinski@gmail.com>
 */
public interface EventDAO extends JpaRepository<Event, Integer> {

}
