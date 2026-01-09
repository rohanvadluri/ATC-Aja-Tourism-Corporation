package com.aja.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aja.Dto.TestimonialsDeleteResponseDto;
import com.aja.Dto.TestimonialsResponseDto;

public interface TestimonialsService {

	// UPDATED METHOD ↓
	public TestimonialsResponseDto addTestmonial(MultipartFile image, String name, String rating, String review);

	public List<TestimonialsResponseDto> viewAll();

	public TestimonialsResponseDto viewById(Long id);

	public TestimonialsResponseDto updateTestimonial(Long id, com.aja.Dto.TestimonialsRequestDto t);

	public TestimonialsDeleteResponseDto deleteTestnomial(Long id);
}
