package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.EnquiriesDeleteResponseDto;
import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.entity.Enquiries;
import com.aja.repository.EnquiriesRepo;
import com.aja.service.EnquiriesService;

@Service
public class EnquiriesServiceImpl implements EnquiriesService {

	@Autowired
	private EnquiriesRepo enquiriesRepo;

	@Override
	public EnquiriesResponseDto saveEnquiry(EnquiriesRequestDto pdto) {
		Enquiries en = new Enquiries();
		BeanUtils.copyProperties(pdto, en);
		Enquiries saveEnt = enquiriesRepo.save(en);
		EnquiriesResponseDto enrd = new EnquiriesResponseDto();
		BeanUtils.copyProperties(saveEnt, enrd);
		return enrd;

	}

	@Override
	public List<EnquiriesResponseDto> getAllEnquiries() {

		List<Enquiries> enquiriesList = enquiriesRepo.findAll();

		List<EnquiriesResponseDto> responseList = new ArrayList<>();

		for (Enquiries enq : enquiriesList) {

			EnquiriesResponseDto dto = new EnquiriesResponseDto();
			BeanUtils.copyProperties(enq, dto);
			responseList.add(dto);
		}

		return responseList;
	}

	@Override
	public EnquiriesResponseDto getEnquiryById(Long enquiryId) {

		Optional<Enquiries> enqOpt = enquiriesRepo.findById(enquiryId);

		if (enqOpt.isPresent()) {
			EnquiriesResponseDto dto = new EnquiriesResponseDto();
			BeanUtils.copyProperties(enqOpt.get(), dto);

			return dto;
		}

		return null;
	}

	@Override
	public EnquiriesDeleteResponseDto deleteEnquiry(Long enquiryId) {
		// TODO Auto-generated method stub
		// Optional<Payments> delbyId = paymentsRepository.findById(paymentId);
		Optional<Enquiries> delbyId = enquiriesRepo.findById(enquiryId);

		EnquiriesDeleteResponseDto enqred = new EnquiriesDeleteResponseDto();

		Enquiries obj = null;

		if (delbyId.isPresent()) {
			obj = delbyId.get();
			obj.setFlag(false);

			enquiriesRepo.save(obj);
			enqred.setDeleted(true);
			enqred.setMessage("Enquiries Deleted Successfully");
		}

		else {
			enqred.setDeleted(false);
			enqred.setMessage("Enquiries Not  Deleted Successfully");
		}

		return enqred;
	}

}
