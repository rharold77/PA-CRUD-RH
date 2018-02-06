package com.pa.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Race {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String time;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Set<RaceEntry> raceEntries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public Set<RaceEntry> getRaceEntries() {
		return raceEntries;
	}

	public void setRaceEntries(Set<RaceEntry> raceEntries) {
		this.raceEntries = raceEntries;
	}
	
	
}
