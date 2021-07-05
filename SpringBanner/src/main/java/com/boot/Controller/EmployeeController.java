package com.boot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.pogo.Employee;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
	@GetMapping(path = "/name" , produces = "application/json")
     public List<Employee> displayEmployeeList() {
    	 return Employee.getEmployeeList();
     }
	
	@GetMapping(path = "/{name}" , produces = "application/json")
    public String displayname(@PathVariable String name) {
   	 return "Spring boot Application  " + name;
    }
}
