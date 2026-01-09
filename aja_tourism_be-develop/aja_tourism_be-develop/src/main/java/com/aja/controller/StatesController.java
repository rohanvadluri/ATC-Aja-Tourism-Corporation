package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.StatesDeleteResponseDto;
import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;
import com.aja.serviceImpl.StatesServiceImpl;

@RestController
@RequestMapping("/api/state")
public class StatesController {
	@Autowired
	private StatesServiceImpl sImpl;
	@PostMapping("/create")
	public StatesResponseDto addState(@RequestBody StatesRequestDto s)
	{
		return sImpl.addState(s);
	}
	@GetMapping("/all")
	public ResponseEntity<List<StatesResponseDto>> viewAllStates()
	{
		List<StatesResponseDto> states = sImpl.viewAllStates();
		return ResponseEntity.ok(states);
	}
	@GetMapping("/{stateId}")
	public ResponseEntity<StatesResponseDto> viewStateById(@PathVariable Long stateId) {

	    StatesResponseDto response = sImpl.viewStateById(stateId);


	    return ResponseEntity.ok(response); // 200
	}

	@PutMapping("/update/{stateId}")
	public ResponseEntity<StatesResponseDto> upadteStates(@PathVariable Long stateId,@RequestBody StatesRequestDto sreq)
	{
		StatesResponseDto res=sImpl.updateState(stateId, sreq);
		return ResponseEntity.ok(res);
		
	}
	@DeleteMapping("/softdelete/{id}")
    public ResponseEntity<StatesDeleteResponseDto> softdelete(@PathVariable Long id) {
    	
	 StatesDeleteResponseDto deleteState = sImpl.deleteState(id);
	
		return ResponseEntity.ok(deleteState);
	}


}
