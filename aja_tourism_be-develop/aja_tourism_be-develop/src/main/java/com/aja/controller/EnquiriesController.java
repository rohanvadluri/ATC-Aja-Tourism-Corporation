package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.EnquiriesDeleteResponseDto;
import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.service.EnquiriesService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin("*")
public class EnquiriesController {

	@Autowired
	private EnquiriesService enquiriesService;

	@PostMapping("/register")
	public ResponseEntity<EnquiriesResponseDto> createEnquiry(@RequestBody EnquiriesRequestDto dto) {
		return ResponseEntity.ok(enquiriesService.saveEnquiry(dto));
	}

	@GetMapping("/all")
	public ResponseEntity<List<EnquiriesResponseDto>> getAllEnquiries() {
		List<EnquiriesResponseDto> enq = enquiriesService.getAllEnquiries();
		return ResponseEntity.ok(enq);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EnquiriesResponseDto> getEnquiryById(@PathVariable("id") Long enquiryId) {
		EnquiriesResponseDto enquiry = enquiriesService.getEnquiryById(enquiryId);
		return ResponseEntity.ok(enquiry);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<EnquiriesDeleteResponseDto> softDelete(@PathVariable Long id) {

		EnquiriesDeleteResponseDto deleteenq = enquiriesService.deleteEnquiry(id);
		return ResponseEntity.ok(deleteenq);
	}

}
