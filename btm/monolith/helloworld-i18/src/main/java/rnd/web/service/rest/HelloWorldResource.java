package rnd.web.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import rnd.web.service.rest.domain.models.Greeting;
import rnd.web.service.rest.domain.services.GreetingService;

@Path("/helloworld/")
public class HelloWorldResource {
    
    @Autowired
    private GreetingService gs;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello World";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{cc}")
	public String sayHello(@PathParam("cc") String countryCode) {
	    
	    if(countryCode == null || countryCode.equals("")) {
	        return sayHello();
	    }
	    
	    Greeting g = gs.sayHello(countryCode);
	    
	    if(g != null) {
    	    return  g.getGreeting() + " World";
	    }
	    
	    return sayHello();
	    
		
	}

}
