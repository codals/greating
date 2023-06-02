package com.codals.greating.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codals.greating.admin.service.AdminService;

@RequestMapping("/api/admin")
@RestController
public class AdminRestController {

	@Autowired
	AdminService service;
	
	@PostMapping("/approve")
	public ResponseEntity<Boolean> changeStatus(@RequestParam("postId") long postId) {
		if(service.approveCheck(postId)) {
			return ResponseEntity.ok().build(); 
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
	}
}
