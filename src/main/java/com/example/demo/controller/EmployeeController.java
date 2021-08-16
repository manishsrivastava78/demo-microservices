package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.response.Employee;
import com.example.demo.model.response.data.DataBase;
import com.example.demo.model.response.exception.NotFound;

@RestController
@RequestMapping("apis/v1/employees")
public class EmployeeController {
	/**
	 * Logger object
	 */
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	private final String KONG_REQ_ID = "kong-request-id";
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<List<Employee>> getAll(@RequestHeader Map<String, String> headers) {
		logger.info("Getting list of all employees...");
		headers.forEach((key, value) -> {
	    	logger.info(String.format("Header '%s' = %s", key, value));
	    	System.out.println(String.format("Header '%s' = %s", key, value));
	    });
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set(KONG_REQ_ID,headers.get(KONG_REQ_ID) == null ? "NOT SET KONG ID" : headers.get(KONG_REQ_ID));

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body(DataBase.getEmployees());
	    
	    //return new ResponseEntity<List<Employee>>(DataBase.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{empId}")
	public Employee getUserById(@PathVariable String empId,@RequestHeader Map<String, String> headers) {
		logger.info("Search employee id "+empId+" in the system...");
		Employee e  =DataBase.getEmployeeById(empId);
		if(e == null) {
			logger.info("Employee id "+empId+" does not exist in the system...");
			throw new NotFound();
		}
		headers.forEach((key, value) -> {
	    	logger.info(String.format("Header '%s' = %s", key, value));
	    	System.out.println(String.format("Header '%s' = %s", key, value));
	    });
		return e;
		}
		
	}
