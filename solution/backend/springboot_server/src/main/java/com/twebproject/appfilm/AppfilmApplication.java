package com.twebproject.appfilm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AppfilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppfilmApplication.class, args);
	}

}
//@todo Procedere allo stesso modo per “film_countries”, “film_crew”, “film_genres” e così via.
	// creare i modelli 
	//creare i repository
	//aggiungere i metodi per la ricerca
	//aggiungere i test
	//aggiungere i controller
	//aggiungere i servizi
	