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
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Horse> getAll() {
        return (List<Horse>) horseRepository.findAll();
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Horse getHorse(@PathVariable String name) {
        return horseRepository.findByName(name);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Horse addHorse(@RequestBody Horse horse) {
        return horseRepository.save(horse);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public Horse updateCourse(@RequestBody Horse horse) {
        return horseRepository.save(horse);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteCourse(@RequestBody Horse horse) {
		horseRepository.delete(horse);
    }
}
