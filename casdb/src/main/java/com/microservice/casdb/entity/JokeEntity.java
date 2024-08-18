package com.microservice.casdb.entity;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class JokeEntity{
	
	@PrimaryKey
	private UUID id;
	private String setup;
	private String punchLine;
	private String type;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getSetup() {
		return setup;
	}
	public void setSetup(String setup) {
		this.setup = setup;
	}
	public String getPunchLine() {
		return punchLine;
	}
	public void setPunchLine(String punchLine) {
		this.punchLine = punchLine;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
