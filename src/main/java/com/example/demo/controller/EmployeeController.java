package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.response.Employee;
import com.example.demo.model.response.data.DataBase;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<List<Employee>> getAll() {
	    return new ResponseEntity<List<Employee>>(DataBase.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{empId}")
	public Employee getUserById(@PathVariable String empId) {
		return DataBase.getEmployeeById(empId);
		}
		
	}
