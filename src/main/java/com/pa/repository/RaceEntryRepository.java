package com.pa.repository;

import org.springframework.data.repository.CrudRepository;

import com.pa.domain.RaceEntry;

public interface RaceEntryRepository extends CrudRepository<RaceEntry, Long> {

}
