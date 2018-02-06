package com.pa.repository;

import org.springframework.data.repository.CrudRepository;

import com.pa.domain.Horse;

public interface HorseRepository extends CrudRepository<Horse, Long> {

	public Horse findByName(String name);
	
}
