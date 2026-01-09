package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.HotelTypesRequestDto;
import com.aja.Dto.HotelTypesResponseDto;
import com.aja.entity.HotelTypes;
import com.aja.serviceImpl.HotelTypesServiceImpl;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin("*")
public class HotelTypesController {

	@Autowired
	private HotelTypesServiceImpl hotelTypesServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<HotelTypesResponseDto> addHotel(@RequestBody HotelTypesRequestDto hotelTypes) {
		return ResponseEntity.ok(hotelTypesServiceImpl.saveHotel(hotelTypes));
	}

	@GetMapping("/all")
	public List<HotelTypes> getAllHotelTypes() {
		return hotelTypesServiceImpl.getAllEnquiries();
	}

	@GetMapping("/{id}")
	public HotelTypes getHotelTypeById(@PathVariable Long id) {
		return hotelTypesServiceImpl.getEnquiryById(id);
	}

	@PutMapping("/update/{id}")
	public HotelTypes updateHotelType(@PathVariable long id, @RequestBody HotelTypes hotelTypes) {

		return hotelTypesServiceImpl.updateHoteType(id, hotelTypes);
	}
}
