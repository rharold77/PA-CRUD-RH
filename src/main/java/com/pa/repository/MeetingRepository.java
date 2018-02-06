package com.pa.repository;

import org.springframework.data.repository.CrudRepository;

import com.pa.domain.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long>{

	
}
