package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	String data = "{\r\n" + 
			"	\"employees\": [{\"empId\":\"123\",\"firstName\":\"Emma\",\"lastName\":\"Jones\",\"department\":\"computers\",\"location\":\"Leeds\"},\r\n" + 
			"	{\"empId\":\"124\",\"firstName\":\"Pete\",\"lastName\":\"Gates\",\"department\":\"finance\",\"location\":\"Paris\"},\r\n" + 
			"	{\"empId\":\"123\",\"firstName\":\"Neil\",\"lastName\":\"Young\",\"department\":\"computers\",\"location\":\"Delhi\"},\r\n" + 
			"	{\"empId\":\"123\",\"firstName\":\"Emma\",\"lastName\":\"Jones\",\"department\":\"computers\",\"location\":\"New York\"},\r\n" + 
			"	{\"empId\":\"123\",\"firstName\":\"Katja\",\"lastName\":\"Larsen\",\"department\":\"admin\",\"location\":\"Stockholm\"}\r\n" + 
			"	]\r\n" + 
			"}";
	
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> getUserByLimit(@RequestParam(value="page",required=false,defaultValue="1") int page, @RequestParam(value="limit",required=false,defaultValue="30") int limit) {
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@GetMapping(path="/{id}")
	public String getUserById(@PathVariable String id) {
		return "user with id:"+id;
	}
	
	
	
	@DeleteMapping
	public String deleteUsers() {
		return "delete user";
	}
	
	@PostMapping
	public String postUsers() {
		return "post users";
	}
	
	@PutMapping
	public String updateUsers() {
		return "update users";
	}
		
}
