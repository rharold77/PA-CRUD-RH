package com.pa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pa.domain.Horse;
import com.pa.domain.Jockey;
import com.pa.repository.HorseRepository;
import com.pa.repository.JockeyRepository;

@RestController
@RequestMapping("/pa/jockey")
public class JockeyController {

	private JockeyRepository jockeyRepository;
	
	@Autowired
	public JockeyController(JockeyRepository jockeyRepository) {
		this.jockeyRepository = jockeyRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Jockey> getAll() {
        return (List<Jockey>) jockeyRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Jockey addJockey(@RequestBody Jockey jockey) {
        return jockeyRepository.save(jockey);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteJockey(@RequestBody Jockey jockey) {
		jockeyRepository.delete(jockey);
    }
}
