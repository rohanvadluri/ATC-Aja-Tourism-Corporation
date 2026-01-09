package com.aja.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aja.Dto.TestimonialsDeleteResponseDto;
import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;
import com.aja.repository.TestimonialsRepo;
import com.aja.service.TestimonialsService;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

	@Autowired
	private TestimonialsRepo tRepo;

	@Override
	public TestimonialsResponseDto addTestmonial(MultipartFile image, String name, String rating, String review) {

		Testimonials t = new Testimonials();
		t.setName(name);
		t.setRating(rating);
		t.setReview(review);
		t.setFlag(true);

		// ⭐ IMAGE UPLOAD PART
		try {
			if (image != null && !image.isEmpty()) {
				String uploadDir = "uploads/";
				String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
				Files.createDirectories(Paths.get(uploadDir));
				Files.write(Paths.get(uploadDir + fileName), image.getBytes());

				t.setImage(fileName); // ⭐ ONLY image name saved in DB
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Testimonials saveEnt = tRepo.save(t);
		TestimonialsResponseDto tdto = new TestimonialsResponseDto();
		BeanUtils.copyProperties(saveEnt, tdto);
		return tdto;
	}

	@Override
	public List<TestimonialsResponseDto> viewAll() {
		// TODO Auto-generated method stub
		List<Testimonials> test = tRepo.findAll();

		List<TestimonialsResponseDto> response = new ArrayList<>();

		for (Testimonials t : test) {
			TestimonialsResponseDto dto = new TestimonialsResponseDto();
			BeanUtils.copyProperties(t, dto);
			response.add(dto);
		}
		return response;
	}

	@Override
	public TestimonialsResponseDto updateTestimonial(Long id, TestimonialsRequestDto t) {
		Optional<Testimonials> UpdateById = tRepo.findById(id);
		if (UpdateById.isEmpty()) {
			return null;
		}

		Testimonials testmonials = UpdateById.get();

		BeanUtils.copyProperties(t, testmonials, "testmonialId");
		// update only required or id fields
		Testimonials updated = tRepo.save(testmonials);

		TestimonialsResponseDto tres = new TestimonialsResponseDto();

		BeanUtils.copyProperties(updated, tres);

		return tres;
	}

	@Override
	public TestimonialsDeleteResponseDto deleteTestnomial(Long id) {
		// TODO Auto-generated method stub

		Optional<Testimonials> byId = tRepo.findById(id);

		TestimonialsDeleteResponseDto tdelRes = new TestimonialsDeleteResponseDto();

		if (byId.isPresent()) {
			Testimonials t = byId.get();
//			soft delete by flag
			t.setFlag(false);
			tRepo.save(t);
			tdelRes.setDeleted(true);
			tdelRes.setMessage("Place Deleted Successfully");

		} else {
			tdelRes.setDeleted(false);
			tdelRes.setMessage("Place Not  Deleted Successfully");
		}
		return tdelRes;
	}

	@Override
	public TestimonialsResponseDto viewById(Long id) {
		// TODO Auto-generated method stub

		Optional<Testimonials> optionalTest = tRepo.findById(id);

		if (optionalTest.isEmpty()) {
			return null;
		}

		Testimonials test = optionalTest.get();

		TestimonialsResponseDto response = new TestimonialsResponseDto();
		BeanUtils.copyProperties(test, response);

		return response;

	}

}
