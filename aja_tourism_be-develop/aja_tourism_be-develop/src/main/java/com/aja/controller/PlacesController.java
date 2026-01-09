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

import com.aja.Dto.PlacesDeleteResponseDto;
import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;
import com.aja.serviceImpl.PlacesServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/place")
public class PlacesController {
	@Autowired
	private PlacesServiceImpl placeImpl;

	@PostMapping("/create")
	public ResponseEntity<PlacesResponseDto> place(@RequestBody PlacesRequestDto p) {

		PlacesResponseDto place = placeImpl.addPlace(p);
		return ResponseEntity.ok(place);
	}

	@GetMapping("/all")
	public ResponseEntity<List<PlacesResponseDto>> getAllPlaces() {
		List<PlacesResponseDto> viewAllPlaces = placeImpl.viewAllPlaces();
		return ResponseEntity.ok(viewAllPlaces);
	}

	@GetMapping("/{placeId}")
	public ResponseEntity<PlacesResponseDto> getplaceById(@PathVariable Long placeId) {
		PlacesResponseDto ps = placeImpl.viewPlace(placeId);
		return ResponseEntity.ok(ps);
	}

	@PutMapping("/{placeId}")
	public ResponseEntity<PlacesResponseDto> update(@PathVariable Long placeId, @RequestBody PlacesRequestDto p) {
		return ResponseEntity.ok(placeImpl.updatePlace(placeId, p));
	}

	@DeleteMapping("/softdelete/{id}")
	public ResponseEntity<PlacesDeleteResponseDto> softdelete(@PathVariable Long id) {

		PlacesDeleteResponseDto deletePlace = placeImpl.deletePlace(id);

		return ResponseEntity.ok(deletePlace);
	}

}
