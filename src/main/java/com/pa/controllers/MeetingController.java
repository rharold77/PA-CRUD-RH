package com.pa.controllers;

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

@RestController
@RequestMapping("/pa/meeting")
public class MeetingController {

	private MeetingRepository meetingRepository;
	
	@Autowired
	public MeetingController(MeetingRepository meetingRepository) {
		this.meetingRepository = meetingRepository;
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }
	
	@RequestMapping(value = "/{meetinId}", method = RequestMethod.PUT)
    public void addRaceToMeeting(@PathVariable Long meetingId, @RequestBody Race race) {
		Meeting meeting = meetingRepository.findOne(meetingId);
		meeting.getRaces().add(race);
		meetingRepository.save(meeting);
    }
}
