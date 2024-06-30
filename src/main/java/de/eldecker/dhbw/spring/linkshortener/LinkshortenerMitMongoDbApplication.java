package de.eldecker.dhbw.spring.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Einstiegspunkt für Programm.
 */
@SpringBootApplication
public class LinkshortenerMitMongoDbApplication {

	public static void main( String[] args ) {

		SpringApplication.run( LinkshortenerMitMongoDbApplication.class, args );
	}

}
