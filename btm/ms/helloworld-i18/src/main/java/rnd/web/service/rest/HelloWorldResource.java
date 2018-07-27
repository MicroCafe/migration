package rnd.web.service.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/helloworld/")
public class HelloWorldResource {
    
    @Autowired
    private Environment env;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello World";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{cc}")
    public String sayHello(@PathParam("cc") String countryCode) {

        if (countryCode == null || countryCode.equals("")) {
            return sayHello();
        }
        
        String api_port = env.getProperty(countryCode);

        try {
            Client client = ClientBuilder.newClient();
            String greeting = client.target("http://localhost:" + api_port + "/helloworld/" + countryCode).request(MediaType.TEXT_PLAIN).get(String.class);
            return greeting + " World";
        } catch(Exception e){
            System.err.println(e.getMessage());
            return sayHello();
        }

    }

}
