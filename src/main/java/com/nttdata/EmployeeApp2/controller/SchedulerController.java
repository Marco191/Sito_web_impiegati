package com.nttdata.EmployeeApp2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.EmployeeApp2.dao.SchedulerConfig;
import com.nttdata.EmployeeApp2.dao.SchedulerRepository;

@RestController
public class SchedulerController {
	
	@Autowired
	private SchedulerRepository schedulerRepository;
	
	@PostMapping( value = "/inserimento", consumes = "application/json", produces = "application/json") 
	public @ResponseBody String insertScheduler( @RequestBody SchedulerConfig sc) {
		
		schedulerRepository.save(sc);
		
		return "Operazione POST eseguita! ";
		
	}
	
	@RequestMapping(path="/lista", method=RequestMethod.GET)
	  public @ResponseBody Iterable<SchedulerConfig> getAllSchedulerConfig() {
	    // This returns a JSON or XML with the users
	    return schedulerRepository.findAll();
	  }
	
	@RequestMapping(path="/getScheduler/{id}", method=RequestMethod.GET)
	  public @ResponseBody Optional<SchedulerConfig> getSchedulerConfig(@PathVariable("id") Integer id) {
	    // This returns a JSON or XML with the users
	    return schedulerRepository.findById(id);
	    
	  }

}
