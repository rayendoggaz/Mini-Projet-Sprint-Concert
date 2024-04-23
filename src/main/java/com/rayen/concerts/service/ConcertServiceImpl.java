package com.rayen.concerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rayen.concerts.entities.Concert;
import com.rayen.concerts.repos.ConcertRepository;


@Service
public class ConcertServiceImpl implements ConcertService{
	
	@Autowired
    ConcertRepository concertRepository;
	
	@Override
    public Concert saveConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    @Override
    public Concert updateConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    @Override
    public void deleteConcert(Concert concert) {
        concertRepository.delete(concert);
    }

    @Override
    public void deleteConcertById(Long id) {
        concertRepository.deleteById(id);
    }

    @Override
    public Concert getConcert(Long id) {
        return concertRepository.findById(id).get();
    }

    @Override
    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

	@Override
	public Page<Concert> getAllConcertsParPage(int page, int size) {
		return concertRepository.findAll(PageRequest.of(page, size));
	}

}
