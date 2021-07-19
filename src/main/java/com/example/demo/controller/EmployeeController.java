package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.response.Employee;
import com.example.demo.model.response.data.DataBase;
import com.example.demo.model.response.exception.NotFound;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	/**
	 * Logger object
	 */
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<List<Employee>> getAll() {
		logger.info("Getting list of all employees...");
	    return new ResponseEntity<List<Employee>>(DataBase.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{empId}")
	public Employee getUserById(@PathVariable String empId) {
		logger.info("Search employee id "+empId+" in the system...");
		Employee e  =DataBase.getEmployeeById(empId);
		if(e == null) {
			logger.info("Employee id "+empId+" does not exist in the system...");
			throw new NotFound();
		}
		return e;
		}
		
	}
