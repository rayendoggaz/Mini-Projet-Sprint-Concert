package com.rayen.concerts;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.service.ConcertService;

@SpringBootApplication
public class ConcertsApplication  implements CommandLineRunner {
	
	@Autowired
    ConcertService concertService;
	
	public static void main(String[] args) {
		SpringApplication.run(ConcertsApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        concertService.saveConcert(new Concert("Concert 1", 50.0, new Date()));
        concertService.saveConcert(new Concert("Concert 2", 60.0, new Date()));
        concertService.saveConcert(new Concert("Concert 3", 70.0, new Date()));
    }

}
