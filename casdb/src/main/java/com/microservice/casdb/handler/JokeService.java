package com.microservice.casdb.handler;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.casdb.entity.JokeEntity;
import com.microservice.casdb.repository.JokeRepository;

@Service
public class JokeService {
	
	@Autowired
	JokeRepository jokeRepository;
	
	public JokeEntity getJoke(UUID id) {
		return jokeRepository.findById(id).orElse(null);
	}
	
	public boolean createJoke(JokeEntity jokeEntity) {
		jokeEntity.setId(UUID.randomUUID());
		JokeEntity savedEntity = jokeRepository.save(jokeEntity);
		return savedEntity != null && savedEntity.getId() != null;
	}
	
	public JokeEntity getRandomJoke() {
        List<JokeEntity> jokes = jokeRepository.findAll();
        if (jokes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
	}
	
}
