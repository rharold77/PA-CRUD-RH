package com.pa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pa.domain.Meeting;
import com.pa.domain.Race;
import com.pa.domain.RaceEntry;
import com.pa.helpers.OddsHelper;
import com.pa.repository.MeetingRepository;
import com.pa.repository.RaceRepository;

@RestController
@RequestMapping("/pa/meeting")
public class MeetingController {

	private MeetingRepository meetingRepository;
	
	private RaceRepository raceRepository;
	
	private OddsHelper oddsHelper;
	
	@Autowired
	public MeetingController(
			MeetingRepository meetingRepository, RaceRepository raceRepository, OddsHelper oddsHelper) {
		this.meetingRepository = meetingRepository;
		this.raceRepository = raceRepository;
		this.oddsHelper = oddsHelper;
	}
	
	/**
	 * Endpoint to get all meetings.
	 * 
	 * @return json array of all meetings.
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Meeting> getMeetings() {
		List<Meeting> meetings = (List<Meeting>) meetingRepository.findAll();
		return meetings;
    }
	
	/**
	 * Endpoint to get a meeting by date.  Currently presumes only
	 * one meeting per day.  This will changes obviously to multiple
	 * meetings.
	 * 
	 * @param date the date in format dd-MM-yyyy
	 * @return the meeting if matched on day
	 */
	@RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public Meeting getMeetingByDate(@PathVariable String date) {
		return meetingRepository.findByDate(date);
    }
	
	/**
	 * Endpoint to get a meeting by date but with odds represented as fractional
	 * rather than decimal values.  Currently presumes only
	 * one meeting per day.  This will changes obviously to multiple
	 * meetings.
	 * 
	 * @param date the date in format dd-MM-yyyy
	 * @return the meeting if matched on day
	 */
	@RequestMapping(value = "/fraction/{date}", method = RequestMethod.GET)
    public Meeting getMeetingByDateWithFractionOdds(@PathVariable String date) {
		Meeting meeting = meetingRepository.findByDate(date);
		for (Race race : meeting.getRaces()) {
		    for (RaceEntry raceEntry : race.getRaceEntries()) {
				raceEntry.setOdds(
						oddsHelper.convertDecimalToFranctionOdds(raceEntry.getOdds()));
			}
		}
		
		return meeting;
    }
	
	/**
	 * Endpoint to add a meeting.
	 * 
	 * @param meeting the meeting.
	 * @return the meeting added.
	 */
	@RequestMapping(method = RequestMethod.POST)
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }
	
	/**
	 * Method to add race to a meeting.  The race does not already need to exist.
	 * The relationship will get created.
	 * 
	 * @param race the race to add.
	 * @param meetingId the meeting id of meeting to add race to.
	 */
	@RequestMapping(value = "/{meetingId}", method = RequestMethod.PUT)
    public void addRaceToMeeting(@RequestBody Race race, @PathVariable Long meetingId) {
		Meeting meeting = meetingRepository.findOne(meetingId);
		meeting.getRaces().add(race);
		meetingRepository.save(meeting);
    }
	
	/**
	 * Method to add a Race Entry to a race.  
	 * 
	 * @param raceEntry the race entry to add
	 * @param raceId the race id of the race to add to.
	 */
	@RequestMapping(value = "/race/{raceId}", method = RequestMethod.PUT)
    public void addRaceEntryToRace(@RequestBody RaceEntry raceEntry, @PathVariable Long raceId) {
		Race race = raceRepository.findOne(raceId);
		race.getRaceEntries().add(raceEntry);
		raceRepository.save(race);
    }
}
