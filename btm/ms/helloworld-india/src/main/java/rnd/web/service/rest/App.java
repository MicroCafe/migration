package rnd.web.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
	    System.getProperties().put( "server.port", 8083);
		SpringApplication.run(new Object[] { AppConfig.class, App.class }, args);
	}
	

}