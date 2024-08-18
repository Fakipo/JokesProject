package com.microservice.casdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.casdb.entity.JokeEntity;
import com.microservice.casdb.handler.JokeService;

@RestController
public class JokeController {
	
	@Autowired JokeService jokeService;
	@RequestMapping("/")
	public String dbCall() {
		return "hello UI db call this is";
	}
	
	@RequestMapping("/createJoke")
	public ResponseEntity createJoke(@RequestBody JokeEntity jokeEntity){
		jokeService.createJoke(jokeEntity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@RequestMapping("/getJoke")
	public JokeEntity getJoke() {
		return jokeService.getRandomJoke();
	}

}
