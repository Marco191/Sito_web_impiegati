package com.nttdata.EmployeeApp2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nttdata.EmployeeApp2.dao.Employee;
import com.nttdata.EmployeeApp2.dao.UserRepository;
import com.nttdata.EmployeeApp2.utils.Convertor;

//import it.sincrono.dao.domain.Anagrafica;

@Controller
@RequestMapping(value="/impiegato")
public class ImpiegatoController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/welcome")
	public String sayWelcome(Map<String, Object> model) {
		model.put("message", "Ciao a tutti!!");
		return "welcome";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Marco") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}
	
	/*
	@GetMapping("/inserisci")
	public String inserimento(Map<String, Object> model) {
		//model.put("message", "Ciao a tutti!!");
		return "inserimento";
	}
	*/
	
	@RequestMapping("/list")
	  public String getList(/*@RequestParam List<Employee> employee, */ Model model) {
		
		String returnValue = "listaimpiegati";
		
		try {
            List<Employee> employee = (List<Employee>) userRepository.findAll();
			//employee = (List<Employee>) userRepository.findAll();
			
			model.addAttribute("employee", employee);
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	@RequestMapping("/listjs")
	  public String getListjs(/*@RequestParam List<Employee> employee, */ Model model) {
		
		String returnValue = "lista";
		
		try {
          List<Employee> employee = (List<Employee>) userRepository.findAll();
			//employee = (List<Employee>) userRepository.findAll();
			
			model.addAttribute("employee", employee);
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	@RequestMapping("/get/{id}")
	  public String get(@PathVariable("id") Integer id, Model model) {
		
		String returnValue = "dettaglioimpiegati";
		//Integer index = Integer.parseInt(id);
		
		try {
          Optional<Employee> employee =  userRepository.findById(id); //è corretto
          //String prova =  employee.get().toString();
          //List<Employee> employee2 =  userRepository.findAllById(id);
         /* List<Employee> employee2 = new ArrayList<>();
          ((ImpiegatoController) employee2).toList(employee); */
          //List<Employee> e2 = new ArrayList<Employee>();
          /*
          Integer id2 = employee.get().getId();
          String nome = employee.get().getFirstName();
          String cognome = employee.get().getLastName();
          String email = employee.get().getEmail();
          *//*
          model.addAttribute("employee", id2);
          model.addAttribute("employee", nome);
          model.addAttribute("employee", cognome);
          model.addAttribute("employee", email);  //si prende un singolo attributo employee associato al valore
		  */	
          //List<Employee> employee2 = (List<Employee>) employee.get();
			//List<Employee> employee = (List<Employee>) userRepository.findAll();
          
          model.addAttribute("employee", employee.get()/*e2.toList(employee)*/); //employee.get()
          //model.addAttribute("employee", employee); //è quello corretto
          /*
          model.addAttribute(id2);
          model.addAttribute(nome);
          model.addAttribute(cognome);
          model.addAttribute(email);
          */
          
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
/*	public static <T> List<T> toList(Optional<T> opt) {
	    return opt
	            .map(Collections::singletonList)
	            .orElseGet(Collections::emptyList);
	} */
	
	@RequestMapping("/openInsert")
    public String openInsert( Model model) {
		
		String returnValue = "inserimento";
		
		try {
			//Map<Integer, String> employee = new HashMap<Integer, String>();
			
			//model.addAttribute("employee", employee);
			model.addAttribute("employee", new Employee());
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	//@RequestMapping(/*value= */"/insert"/*, consumes = "application/json"*/)      //consumes = "application/x-www-form-urlencoded"
	@PostMapping(path = "/insert", consumes = "application/x-www-form-urlencoded") //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    public String insert( Model model, Employee e) {
		
		String returnValue = "redirect:/impiegato/list";
		
		try {
			//Map<Integer, String> employee = new HashMap<Integer, String>();
			
			model.addAttribute("e", userRepository.save(e) );
			
			//userRepository.save(e);
			
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	/*
	@PostMapping(path = "/insert2", consumes = "application/json", produces = "application/json") //consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    public String insert2( Model model, Employee e) {
		
		String returnValue = "redirect:/impiegato/list";
		
		try {
			//Map<Integer, String> employee = new HashMap<Integer, String>();
			
			model.addAttribute("e", userRepository.save(e) );
			
			//userRepository.save(e);
			
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	*/
	@RequestMapping("/delete/{id}")
	  public String delete(@PathVariable("id") Integer id, Model model) {
		
		String returnValue = "redirect:/impiegato/list";
		
		try {
            userRepository.deleteById(id);
            //userRepository.delete(employee);
			
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	@RequestMapping("/openUpdate/{id}")
    public String openUpdate(@PathVariable("id") Integer id, Model model) {
		
		String returnValue = "aggiornaimpiegato";
		
		try {
			//Map<Integer, String> employee = new HashMap<Integer, String>();
			
			//model.addAttribute("employee", userRepository.findById(id));
			
		    Optional<Employee> employee =  userRepository.findById(id);
			
			model.addAttribute("employee", employee.get());    //ho così usato una lista monodimensionale con il get per optional, passando solo id
			 
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	//@RequestMapping("/update")      //method = RequestMethod.GET
	//@RequestMapping(value="/update/{id}" , method = RequestMethod.POST)
	@PostMapping("/update/{id}") //   /{id}
    public String update( @PathVariable("id") Integer id, Model model, Employee e) {
		
		String returnValue = "redirect:/impiegato/list";
		
		try {
			/*
			Employee e2 = new Employee(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail());
			
			model.addAttribute("e", userRepository.save(e2) );			
			*/
			model.addAttribute("e", userRepository.save(e) );
		}catch(ServiceException ex) {
			ex.printStackTrace();
		}

	    return returnValue;
	  }
	
	

}
