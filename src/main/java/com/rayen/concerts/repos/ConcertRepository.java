package com.rayen.concerts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.concerts.entities.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

}