package com.microservice.casdb.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.microservice.casdb.entity.JokeEntity;

@Repository
public interface JokeRepository extends CassandraRepository<JokeEntity, UUID>{
	
}
