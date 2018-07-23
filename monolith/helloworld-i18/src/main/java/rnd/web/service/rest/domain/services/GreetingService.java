package rnd.web.service.rest.domain.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import rnd.web.service.rest.domain.models.Greeting;

@Service
public class GreetingService {


    private static Map<String, CountryService> ccMap = new HashMap<>();

    static {

        ccMap.put("IN", new IndiaService());
        ccMap.put("US", new USAService());
        ccMap.put("ES", new SpainService());
        ccMap.put("HAW", new HawaiiService());
        ccMap.put("FR", new FranceService());


    }

    public Greeting sayHello(String countryCode) {
        CountryService cs =  ccMap.get(countryCode);
        if(cs != null) {
            return cs.sayHello();
        }
        return null;
    }

}
