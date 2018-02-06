package com.pa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pa.domain.Jockey;
import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.domain.RaceEntry;

public interface MeetingRepository extends CrudRepository<Meeting, Long>{

	
}
