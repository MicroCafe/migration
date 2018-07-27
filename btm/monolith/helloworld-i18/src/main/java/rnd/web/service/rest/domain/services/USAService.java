package rnd.web.service.rest.domain.services;

import rnd.web.service.rest.domain.models.Greeting;

public class USAService implements CountryService {
    
    public Greeting sayHello() {
        return new Greeting("Hello");
    }
    
}

