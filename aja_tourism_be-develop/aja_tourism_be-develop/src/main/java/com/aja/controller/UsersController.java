package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.UsersDeleteResponseDto;
import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;
import com.aja.service.UsersService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UsersController {

	@Autowired

	private UsersService userService;

	// register user
	@PostMapping("/add")
	public ResponseEntity<UsersResponseDto> registerUser(@RequestBody UsersRequestDto u) {

		UsersResponseDto uRes = userService.registerUsers(u);
		return ResponseEntity.ok(uRes);
	}

	// get all users

	@GetMapping("/all")
	public List<UsersResponseDto> getAllUsers() {
		return userService.getAllUsers();
	}

//	update user
	@PutMapping("/update/{id}")
	public ResponseEntity<UsersResponseDto> updateUser(@PathVariable Long id, @RequestBody UsersRequestDto user) {

		UsersResponseDto updated = userService.updateUser(id, user);
		return ResponseEntity.ok(updated);
	}

//	login
	@PostMapping("/login")
	public ResponseEntity<UsersResponseDto> login(@RequestBody UsersRequestDto request) {

		UsersResponseDto user = userService.login(request.getEmail(), request.getPassword());

		return ResponseEntity.ok(user);
	}

	// soft del
	@DeleteMapping("/delete/{id}")
	public UsersDeleteResponseDto deleteUser(@PathVariable Long id) {

		return userService.deleteUser(id);
	}
}
