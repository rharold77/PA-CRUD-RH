package com.pa.repository.impl;

import java.util.List;

import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.repository.RaceRepository;

public class RaceRepositoryImpl implements RaceRepository {

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Race arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Race> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Race> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Race> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Race findOne(Long arg0) {
		Meeting meeting = MeetingRepositoryImpl.database.get("08-02-2018");
		
		return this.findRaceById(meeting, arg0);			
	}
	
	private Race findRaceById(Meeting meeting, Long id) {
		List<Race> races = meeting.getRaces();
		for (Race raceToFind : races) {
			if(raceToFind.getId().equals(id)) {
				return raceToFind;
			}
		}
		
		return null;
	}

	@Override
	public <S extends Race> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Race> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
