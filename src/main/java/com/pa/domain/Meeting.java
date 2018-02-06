package com.pa.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Meeting {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date date;
	
	@OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
	private List<Race> races;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}
	
	
}
