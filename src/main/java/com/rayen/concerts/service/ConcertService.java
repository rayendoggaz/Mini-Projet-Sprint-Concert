package com.rayen.concerts.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rayen.concerts.entities.Concert;

public interface ConcertService {
    Concert saveConcert(Concert concert);
    Concert updateConcert(Concert concert);
    void deleteConcert(Concert concert);
    void deleteConcertById(Long id);
    Concert getConcert(Long id);
    List<Concert> getAllConcerts();
    
    Page<Concert> getAllConcertsParPage(int page, int size);
}
