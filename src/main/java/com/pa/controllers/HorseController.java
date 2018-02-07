package com.pa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pa.domain.Horse;
import com.pa.repository.HorseRepository;

@RestController
@RequestMapping("/pa/horse")
public class HorseController {

	private HorseRepository horseRepository;
	
	@Autowired
	public HorseController(HorseRepository horseRepository) {
		this.horseRepository = horseRepository;
	}
	
	/**
	 * Endpoint to get all horse.
	 * 
	 * @return json array of all horse data 
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Horse> getAll() {
        return (List<Horse>) horseRepository.findAll();
    }
	
	/**
	 * Endpoint to get a horse by name.
	 * 
	 * @param name the name of the horse
	 * @return json object of horse 
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Horse getHorse(@PathVariable String name) {
        return horseRepository.findByName(name);
    }
	
	/**
	 * Endpoint to add a new horse.
	 * 
	 * @param horse the horse
	 * @return the horse added.
	 */
	@RequestMapping(method = RequestMethod.POST)
    public Horse addHorse(@RequestBody Horse horse) {
        return horseRepository.save(horse);
    }
	
	/**
	 * Endpoint to update a horse
	 * 
	 * @param horse the horse to update with id
	 * @return the horsed updated
	 */
	@RequestMapping(method = RequestMethod.PUT)
    public Horse updateHorse(@RequestBody Horse horse) {
        return horseRepository.save(horse);
    }
	
	/**
	 * Endpoint to delete a horse
	 * 
	 * @param horse the horse to delete with id.
	 */
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteHorse(@RequestBody Horse horse) {
		horseRepository.delete(horse);
    }
}
