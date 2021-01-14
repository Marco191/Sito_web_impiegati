package com.nttdata.EmployeeApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.EmployeeApp2.dao.Employee;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Employee, Integer> {
	
	//List<Employee> findById(Integer id);
	/*public List<Bar> get(Optional<Foo> foo) {
	     return foo.map(x -> x.getBazList()
	                          .stream()
	                          .map(Baz::getBar)
	                          .collect(Collectors.toList()))
	               .orElse(Collections.emptyList());
	}*/

}