package com.aja.service;

import java.util.List;

import com.aja.Dto.EnquiriesDeleteResponseDto;
import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;

public interface EnquiriesService {

	public EnquiriesResponseDto saveEnquiry(EnquiriesRequestDto enquiry);

	public List<EnquiriesResponseDto> getAllEnquiries();

	//public Enquiries getEnquiryById(Long enquiryId);
	
	public EnquiriesResponseDto getEnquiryById(Long enquiryId);

	//public String deleteEnquiry(Long enquiryId);
	
	public EnquiriesDeleteResponseDto deleteEnquiry(Long  enquiryId);


}
