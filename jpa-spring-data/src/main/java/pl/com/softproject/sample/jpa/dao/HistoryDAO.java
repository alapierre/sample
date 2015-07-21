package pl.com.softproject.sample.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import pl.com.softproject.sample.jpa.model.AbstractHistory;

/**
 * Copyright 2015-07-21 the original author or authors.
 */
public interface HistoryDAO extends CrudRepository<AbstractHistory, Long>{

}
