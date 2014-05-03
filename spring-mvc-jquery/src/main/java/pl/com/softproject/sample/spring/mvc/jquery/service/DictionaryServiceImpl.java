/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.sample.spring.mvc.jquery.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.com.softproject.sample.spring.mvc.jquery.model.DictionaryItem;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    String[] data = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps",
        "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu",
        "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};

    @Override
    public List<DictionaryItem> loadByNameFragment(String nameFramgent) {

        String country;
        nameFramgent = nameFramgent.toLowerCase();

        List<DictionaryItem> matched = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            country = data[i].toLowerCase();
            if (country.startsWith(nameFramgent)) {
                matched.add(new DictionaryItem((long) i, country));
            }
        }
        return matched;
    }

}
