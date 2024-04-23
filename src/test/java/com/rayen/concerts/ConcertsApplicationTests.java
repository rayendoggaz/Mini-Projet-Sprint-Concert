package com.rayen.concerts;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.repos.ConcertRepository;
import com.rayen.concerts.service.ConcertService;

@SpringBootTest
class ConcertsApplicationTests {

	 @Autowired
	 private ConcertRepository concertRepository;
	 
	 @Autowired
	 private ConcertService concertService;
	 
	 @Test
	  public void testCreateConcert() {
	      Concert concert = new Concert("A Tour", 20.50, new Date());
	      concertRepository.save(concert);
	  }
	  
	  @Test
	    public void testFindConcert() {
	        Concert concert = concertRepository.findById(1L).get();
	        System.out.println(concert);
	  }
	  
	  @Test
	  public void testUpdateConcert() {
	      Concert concert = concertRepository.findById(1L).get();
	      concert.setPrixConcert(1000.0);
	      concertRepository.save(concert);
	      System.out.println(concert);
	  }
	  
	  @Test
	    public void testDeleteConcert() {
	        concertRepository.deleteById(1L);
	    }

	    @Test
	    public void testListerTousConcerts() {
	        List<Concert> concerts = concertRepository.findAll();
	        for (Concert concert : concerts) {
	            System.out.println(concert);
	        }
	    }
	    
	    @Test
	    public void testFindByNomConcertContains() {
	        Page<Concert> concerts = concertService.getAllConcertsParPage(0, 2);
	        System.out.println(concerts.getSize());
	        System.out.println(concerts.getTotalElements());
	        System.out.println(concerts.getTotalPages());
	        concerts.getContent().forEach(concert -> {
	            System.out.println(concert.toString());
	        });
	        /* Alternatively:
	        for (Concert concert : concerts) {
	            System.out.println(concert);
	        } */
	    }

}
