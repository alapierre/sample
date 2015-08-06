/*
 * Copyright 2015-08-06 the original author or authors.
 */
package pl.com.softproject.sample.oauth.exceptions;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class NoAuthInfoAvailableException extends RuntimeException {

    public NoAuthInfoAvailableException() {
    }

    public NoAuthInfoAvailableException(String message) {
        super(message);
    }

    public NoAuthInfoAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAuthInfoAvailableException(Throwable cause) {
        super(cause);
    }
    
    
    
}
