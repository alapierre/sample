/*
 * Copyright 2015-08-06 the original author or authors.
 */
package pl.com.softproject.sample.oauth.service;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.com.softproject.sample.oauth.exceptions.NoAuthInfoAvailableException;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Service
public class UserServiceImpl implements UserService {

    protected Logger logger = Logger.getLogger(getClass());

    @Override
    public User getPrincipal() {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = null;

        if (auth != null) {
            user = (User) auth.getPrincipal();
        }

        return user;
    }

    @Override
    public String getLoggedUserLogin() {

        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            final Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                final UserDetails userDetails = (UserDetails) principal;
                return userDetails.getUsername();
            }
        }

        logger.warn("brak SecurityContext");

        throw new NoAuthInfoAvailableException("Brak informacji o zalogowanym użytkowniku");
    }

    @Override
    public boolean isUserInAnyRole(final String... roles) {

        final SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }

        final Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return false;
        }

        for (final String role : roles) {
            for (final GrantedAuthority auth : authentication.getAuthorities()) {
                if (role.equals(auth.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String[] getUserRoles() {

        final SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            throw new NoAuthInfoAvailableException("Brak informacji o zalogowanym użytkowniku");
        }

        final Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            throw new NoAuthInfoAvailableException("Brak informacji o zalogowanym użytkowniku");
        }

        Set<String> roles = new HashSet<>();
        
        for (final GrantedAuthority auth : authentication.getAuthorities()) {
            roles.add(auth.getAuthority());
        }

        return roles.toArray(new String[0]);
    }

}
