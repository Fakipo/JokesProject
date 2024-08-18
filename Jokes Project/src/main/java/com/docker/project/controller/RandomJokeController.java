package com.docker.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.docker.project.beans.Joke;

@RestController
@RequestMapping("/")
public class RandomJokeController {
	
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public String home() {
        return "Hello World!";
    }

    @GetMapping("jokeme")
    public String helloJoke() {
        return giveMeAJoke();
    }
    
    @GetMapping("get10Jokes")
    public List<Joke> tenJokes() {
        String uri = "https://official-joke-api.appspot.com/random_ten";
        ResponseEntity<List<Joke>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Joke>>() {}
        );
        List<Joke> jokes = response.getBody();
        return jokes;
    }
    
    private String giveMeAJoke() {
        String uri = "https://official-joke-api.appspot.com/random_joke";
        Joke joke = restTemplate.getForObject(uri, Joke.class);
        return joke.getSetup() + " ... " + joke.getPunchline();
    }
}
