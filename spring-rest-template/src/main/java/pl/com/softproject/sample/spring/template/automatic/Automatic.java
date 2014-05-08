/*
 * Copyright 2014-05-08 the original author or authors.
 */
package pl.com.softproject.sample.spring.template.automatic;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Automatic {

    public static void main(String[] args) {

        // TODO: NOT WORKING !!!!!!!!!!!!!!!!!
        
        String host = "https://...............";
        String ser = "/alfresco/service/api/people";
        int port = 443;

        ApplicationContext ctx = new ClassPathXmlApplicationContext("rest-context.xml");

        RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
        createSecureTransport(restTemplate, host, port);

        String res = restTemplate.getForObject(host + ser, String.class);

        System.out.println(res);

    }

    private static void createSecureTransport(RestTemplate restTemplate, String host, int port) {
        HttpComponentsClientHttpRequestFactory requestFactory
                = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
        DefaultHttpClient httpClient
                = (DefaultHttpClient) requestFactory.getHttpClient();
        httpClient.getCredentialsProvider().setCredentials(
                new AuthScope(host, port, AuthScope.ANY_REALM),
                new UsernamePasswordCredentials("user", "pass"));
    }

}
