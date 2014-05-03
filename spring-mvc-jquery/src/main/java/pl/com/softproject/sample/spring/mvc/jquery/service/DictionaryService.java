/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.sample.spring.mvc.jquery.service;

import java.util.List;
import pl.com.softproject.sample.spring.mvc.jquery.model.DictionaryItem;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface DictionaryService {

    List<DictionaryItem> loadByNameFragment(String nameFramgent);
    
}
