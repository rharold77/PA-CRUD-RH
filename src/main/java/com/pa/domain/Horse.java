package com.pa.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Horse {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer age;
	@OneToMany(mappedBy = "horse", cascade = CascadeType.ALL)
	private Set<RaceEntry> raceEntries;
	
	public Horse() {};
	
	public Horse(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<RaceEntry> getRaceEntries() {
		return raceEntries;
	}
	
	
}
