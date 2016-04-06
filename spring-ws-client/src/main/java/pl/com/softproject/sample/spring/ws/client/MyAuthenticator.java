/**
 * Copyright 2016-03-01 the original author or authors.
 */
package pl.com.softproject.sample.spring.ws.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class MyAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {

        PasswordAuthentication auth = new PasswordAuthentication("admin",
                "test.11".toCharArray());


        return auth;
    }
}
