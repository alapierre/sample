/*
 * Copyright 2014-05-08 the original author or authors.
 */
package pl.com.softproject.sample.spring.template;

import org.apache.commons.codec.binary.Base64;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * by http://www.baeldung.com/2012/04/16/how-to-use-resttemplate-with-basic-authentication-in-spring-3-1/
 * 
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ManualAuth {

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("rest-context.xml");

        RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
        
//        HttpEntity httpEntity = new HttpEntity(createHeaders("", ""));
//
//        ResponseEntity<String> resp = restTemplate.exchange(".........../alfresco/service/api/people",
//                HttpMethod.POST, httpEntity, String.class);

        SSLUtil.turnOffSslChecking();

        ResponseEntity<String> resp = restTemplate.getForEntity("https://doaj.org/api/v1/search/journals/issn%3A1874-9496", String.class);
        
        System.out.println(resp);

    }

    static HttpHeaders createHeaders(final String username, final String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

}
