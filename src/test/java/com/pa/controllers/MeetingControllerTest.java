package com.pa.controllers;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.domain.RaceEntry;
import com.pa.helpers.OddsHelper;
import com.pa.repository.MeetingRepository;
import com.pa.repository.RaceRepository;
import com.pa.repository.impl.MeetingRepositoryImpl;
import com.pa.repository.impl.RaceRepositoryImpl;

public class MeetingControllerTest {

	MeetingRepository meetingRepository = new MeetingRepositoryImpl();
	RaceRepository raceRepository = new RaceRepositoryImpl();
	OddsHelper oddsHelper = new OddsHelper();
	
	@Test
	public void shouldReturnAllMeeting() {
		MeetingController meetingController = 
				new MeetingController(meetingRepository, raceRepository, oddsHelper);
		
		List<Meeting> meetings = meetingController.getMeetings();
	
		assertThat(meetings.size(), equalTo(2));
	}
	
	@Test
	public void shouldReturnMeetingByDate() {
		MeetingController meetingController = 
				new MeetingController(meetingRepository, raceRepository, oddsHelper);
		
		Meeting meeting = meetingController.getMeetingByDate("08-02-2018");
	
		assertThat(meeting.getCourse().getName(), equalTo("Ripon"));
		assertThat(meeting.getCourse().getDistance(), equalTo("3m 1f"));
	}
	
	@Test
	public void shouldReturnMeetingByDateWithFractionalOdds() {
		MeetingController meetingController = 
				new MeetingController(meetingRepository, raceRepository, oddsHelper);
		
		Meeting meeting = meetingController.getMeetingByDateWithFractionOdds("07-02-2018");
	
		assertThat(meeting.getCourse().getName(), equalTo("York"));
		assertThat(meeting.getCourse().getDistance(), equalTo("5m 6f"));
		
		Race race = meeting.getRaces().get(0);
		Set<RaceEntry> raceEntries = race.getRaceEntries();
		RaceEntry raceEntry = raceEntries.iterator().next();
		
		assertThat(raceEntry.getOdds(), equalTo("5/10"));
	}
	
	@Test
	public void shouldAddRaceToMeeeting() {
		MeetingController meetingController = 
				new MeetingController(meetingRepository, raceRepository, oddsHelper);
		
		Meeting meeting = meetingController.getMeetingByDate("08-02-2018");
		
		assertThat(meeting.getRaces().size(), equalTo(2));
		
		Race race = new Race();
		race.setTime("2:35");
		
		meetingController.addRaceToMeeting(race, meeting.getId());
		
		meeting = meetingController.getMeetingByDate("08-02-2018");
		assertThat(meeting.getRaces().size(), equalTo(3));
	}
	
	@Test
	public void shouldAddRaceEntryToRace() {
		MeetingController meetingController = 
				new MeetingController(meetingRepository, raceRepository, oddsHelper);
		
		Meeting meeting = meetingController.getMeetingByDate("08-02-2018");
		Race race = findRaceById(meeting, 1L);
		
		assertThat(race.getRaceEntries().size(), equalTo(2));
		
		RaceEntry raceEntry = new RaceEntry();
		raceEntry.setId(3L);
		raceEntry.setOdds("9.5");
		meetingController.addRaceEntryToRace(raceEntry, 1L);
		
		meeting = meetingController.getMeetingByDate("08-02-2018");
		race = findRaceById(meeting, 1L);
		
		assertThat(race.getRaceEntries().size(), equalTo(3));
	
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
	
	
}
