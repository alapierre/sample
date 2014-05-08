/*
 * Copyright 2014-05-08 the original author or authors.
 */
package pl.com.softproject.sample.spring.template.automatic;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class AutomaticAuth {

    private static String user = "";
    private static String pass = "";
    
    public static void main(String[] args) {

        String url = "https://......................./alfresco/service/api/people";
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("rest-context.xml");

        RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
        restTemplate.setRequestFactory(createSecureTransport());

        String res = restTemplate.getForObject(url, String.class);

        System.out.println(res);

    }

    private static ClientHttpRequestFactory createSecureTransport() {
        
        int timeout = 5;
        RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();

        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(null, -1, AuthScope.ANY_REALM), new UsernamePasswordCredentials(user, pass));
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).setDefaultCredentialsProvider(credentialsProvider).build();

        return new HttpComponentsClientHttpRequestFactory(client);
        
    }
    

}
