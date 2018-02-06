package com.pa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pa.domain.Jockey;
import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.domain.RaceEntry;
import com.pa.repository.MeetingRepository;
import com.pa.repository.RaceRepository;

@RestController
@RequestMapping("/pa/meeting")
public class MeetingController {

	private MeetingRepository meetingRepository;
	
	private RaceRepository raceRepository;
	
	@Autowired
	public MeetingController(MeetingRepository meetingRepository, RaceRepository raceRepository) {
		this.meetingRepository = meetingRepository;
		this.raceRepository = raceRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Meeting> getMeetings() {
		List<Meeting> meetings = (List<Meeting>) meetingRepository.findAll();
		return meetings;
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }
	
	@RequestMapping(value = "/{meetingId}", method = RequestMethod.PUT)
    public void addRaceToMeeting(@RequestBody Race race, @PathVariable Long meetingId) {
		Meeting meeting = meetingRepository.findOne(meetingId);
		meeting.getRaces().add(race);
		meetingRepository.save(meeting);
    }
	
	@RequestMapping(value = "/race/{raceId}", method = RequestMethod.PUT)
    public void addRaceToMeeting(@RequestBody RaceEntry raceEntry, @PathVariable Long raceId) {
		Race race = raceRepository.findOne(raceId);
		race.getRaceEntries().add(raceEntry);
		raceRepository.save(race);
    }
}
