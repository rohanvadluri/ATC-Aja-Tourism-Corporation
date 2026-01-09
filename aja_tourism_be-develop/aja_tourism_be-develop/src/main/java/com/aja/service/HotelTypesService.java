package com.aja.service;

import java.util.List;

import com.aja.Dto.HotelTypesRequestDto;
import com.aja.Dto.HotelTypesResponseDto;
import com.aja.entity.HotelTypes;

public interface HotelTypesService {

	HotelTypesResponseDto saveHotel(HotelTypesRequestDto hotelTypes);

	public List<HotelTypes> getAllEnquiries();

	public HotelTypes getEnquiryById(Long Id);

	public HotelTypes updateHoteType(long id, HotelTypes hotelTypes);
}
