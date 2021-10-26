package com.netcracker.restSimple;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

public class CalculateRestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        URI baseURI = null;
        try{
            baseURI = new URI("http://localhost:8080/rest");
        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }
        WebTarget target = client.target(baseURI).path("calc").path("add").path("1").path("7");
        Response response = target.request().post(null);
        Response response1 = target.request().get();
        System.out.println(response.readEntity(String.class));
        System.out.println(response1.readEntity(String.class));
    }
}
