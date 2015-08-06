/*
 * Copyright 2015-08-06 the original author or authors.
 */
package pl.com.softproject.sample.oauth.service;

import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public interface UserService {

    String getLoggedUserLogin();

    User getPrincipal();

    String[] getUserRoles();

    boolean isUserInAnyRole(final String... roles);
    
}
