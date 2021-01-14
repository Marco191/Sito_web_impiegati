package com.nttdata.EmployeeApp2.controller;

import java.util.Optional;

//import org.apache.catalina.User;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.EmployeeApp2.dao.Employee;
import com.nttdata.EmployeeApp2.dao.UserRepository;

@RestController
public class EmployeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Ciao a tutti!";
	}
	
	//@RequestMapping(value="/insert", method=RequestMethod.POST)
	@PostMapping( value = "/insert", consumes = "application/json", produces = "application/json") 
	public @ResponseBody String insertEmployee( @RequestBody Employee e/*@RequestParam String nome, @RequestParam String cognome, @RequestParam String email*/) {
		
		/*
		Employee e = new Employee();
		
		e.setFirstName(nome);
		e.setLastName(cognome);
		e.setEmail(email);
		
		e.setFirstName("dddd");
		e.setLastName("ffff");
		e.setEmail("llll"); */
		
		userRepository.save(e);
		
		return "Operazione POST eseguita! ";
		
	}
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	  public @ResponseBody Iterable<Employee> getAllEmployee() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	  }
	
	@RequestMapping(path="/get/{id}", method=RequestMethod.GET)
	  public @ResponseBody Optional<Employee> getEmployee(@PathVariable("id") Integer id) {
	    // This returns a JSON or XML with the users
	    return userRepository.findById(id);
	    
	  }
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	  public @ResponseBody String deleteEmployee(@PathVariable("id") Integer id) {
	    // This returns a JSON or XML with the users
	    userRepository.deleteById(id);
	    
	    return "Cancellazione avvenuta con successo! ";
	  }
	
	/*
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Employee> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	  }
	  */
	
	/*
	@PostMapping(path="/insert/{id}")
	public ResponseEntity<Employee> inserimento(@RequestBody String nome, @RequestBody String cognome, @RequestBody String email) {
	     //your imp
        Employee e = new Employee();
		
		e.setFirstName(nome);
		e.setLastName(cognome);
		e.setEmail(email);
		
		userRepository.save(e);
		
		return "Operazione POST eseguita! ";
	}
	*/
	//@RequestMapping(value="/update", method=RequestMethod.PUT)
	@PutMapping( value = "/update", consumes = "application/json", produces = "application/json") 
	public @ResponseBody String updateEmployee( /*@PathVariable("id") Integer id,*/@RequestBody Employee e /*, @RequestBody String nome, @RequestBody String cognome, @RequestBody String email*/) {
		
		//Employee e = new Employee();
		
		if(e.getId() != null) {
			/*
		       e.setFirstName(nome);
		       e.setLastName(cognome);
		       e.setEmail(email);
		    */
		       userRepository.save(e);
		
		       return "Operazione PUT eseguita! ";
		}
		else return "Non eseguita!";
		
	}
	
	/*
	@RequestMapping("/{id}")
	  public String showUserForm(@PathVariable("id") Integer id, Model model) {
	    
	    // Do null check for id
	    User user = userRepository.findOne(id);
	    // Do null check for user

	    model.addAttribute("user", user);
	    return "user";
	  }
	*/

}
