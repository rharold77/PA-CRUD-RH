package com.pa.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jockey {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "jockey", cascade = CascadeType.ALL)
	private Set<RaceEntry> raceEntries;
	
	public Jockey() {};
	
	public Jockey(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Set<RaceEntry> getRaceEntries() {
		return raceEntries;
	}
	
}
