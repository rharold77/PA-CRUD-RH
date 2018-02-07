package com.pa.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pa.domain.Course;
import com.pa.domain.Horse;
import com.pa.domain.Jockey;
import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.domain.RaceEntry;
import com.pa.repository.MeetingRepository;

public class MeetingRepositoryImpl implements MeetingRepository {

	public static Map<String, Meeting> database = new HashMap<String, Meeting>();

	static {

		Meeting meeting = buildMeeting(1L, "07-02-2018", new Course("York", "5m 6f"));
		database.put(meeting.getDate(), meeting);

		meeting = buildMeeting(2L, "08-02-2018", new Course("Ripon", "3m 1f"));
		database.put(meeting.getDate(), meeting);
	}

	private static Meeting buildMeeting(Long id, String date, Course course) {
		Meeting meeting = new Meeting();
		meeting.setDate(date);
		meeting.setId(id);

		meeting.setCourse(course);

		List<Race> races = new ArrayList<Race>();
		Race race = new Race();
		race.setId(1L);
		race.setTime("4:55");

		Set<RaceEntry> raceEntries = new HashSet<RaceEntry>();
		RaceEntry entry = new RaceEntry();
		entry.setHorse(new Horse("Billy Goat", 4));
		entry.setJockey(new Jockey("P", "Mullins"));
		entry.setOdds("3.5");
		entry.setWeight("8-8");

		raceEntries.add(entry);

		entry = new RaceEntry();
		entry.setHorse(new Horse("The Gambler", 3));
		entry.setJockey(new Jockey("AP", "McCoy"));
		entry.setOdds("1.5");
		entry.setWeight("8-9");

		raceEntries.add(entry);
		
		race.setRaceEntries(raceEntries);
		races.add(race);

		race = new Race();
		race.setTime("5:20");
		race.setId(2L);

		raceEntries = new HashSet<RaceEntry>();

		entry = new RaceEntry();
		entry.setHorse(new Horse("Climbing Joe", 6));
		entry.setJockey(new Jockey("P", "Mullins"));
		entry.setOdds("2.5");
		entry.setWeight("8-10");

		raceEntries.add(entry);

		entry = new RaceEntry();
		entry.setHorse(new Horse("Get me a Pint", 6));
		entry.setJockey(new Jockey("AP", "McCoy"));
		entry.setOdds("6.5");
		entry.setWeight("8-9");

		raceEntries.add(entry);

		race.setRaceEntries(raceEntries);
		races.add(race);
		meeting.setRaces(races);
		return meeting;
	}

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
	public void delete(Meeting arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Meeting> arg0) {
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
	public Iterable<Meeting> findAll() {
		List<Meeting> meetings = new ArrayList<Meeting>();

		for (String key : database.keySet()) {
			Meeting meeting = database.get(key);
			meetings.add(meeting);
		}

		return meetings;
	}

	@Override
	public Iterable<Meeting> findAll(Iterable<Long> arg0) {
		return null;
	}

	@Override
	public Meeting findOne(Long arg0) {
		for (String key : database.keySet()) {
			Meeting meeting = database.get(key);
			if(meeting.getId().equals(arg0)) {
				return meeting;
			}
		}
		
		return null;
	}

	@Override
	public <S extends Meeting> S save(S arg0) {
		database.put(arg0.getDate(), arg0);
		
		return arg0;
	}

	@Override
	public <S extends Meeting> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meeting findByDate(String date) {
		for (String key : database.keySet()) {
			Meeting meeting = database.get(key);
			if(meeting.getDate().equals(date)) {
				return meeting;
			}
		}
		
		return null;
	}

}
