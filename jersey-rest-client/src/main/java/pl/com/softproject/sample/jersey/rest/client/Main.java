/*
 * Copyright 2014-05-08 the original author or authors.
 */
package pl.com.softproject.sample.jersey.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://................../alfresco/service/api/people";
        String user = "", pass = "";

        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(user, pass));

        WebResource webResource = client.resource(url);

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String outputFromServer = response.getEntity(String.class);
        
        Map<String, String> map;
        ObjectMapper mapper = new ObjectMapper();
        map = mapper.readValue(outputFromServer, HashMap.class);

        System.out.println(map);

    }

}
