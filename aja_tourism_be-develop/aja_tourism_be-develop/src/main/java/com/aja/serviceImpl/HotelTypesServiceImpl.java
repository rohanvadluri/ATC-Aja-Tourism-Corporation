package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.HotelTypesRequestDto;
import com.aja.Dto.HotelTypesResponseDto;
import com.aja.entity.HotelTypes;
import com.aja.repository.HotelTypesRepo;
import com.aja.service.HotelTypesService;

@Service
public class HotelTypesServiceImpl implements HotelTypesService {
	@Autowired
	private HotelTypesRepo hotelTypesRepo;

	@Override
	public HotelTypesResponseDto saveHotel(HotelTypesRequestDto hotelTypes) {
		// TODO Auto-generated method stub

		HotelTypes h = new HotelTypes();
		BeanUtils.copyProperties(hotelTypes, h);
		HotelTypes savent = hotelTypesRepo.save(h);
		HotelTypesResponseDto hdto = new HotelTypesResponseDto();
		BeanUtils.copyProperties(savent, hdto);
		return hdto;
	}

	@Override
	public List<HotelTypes> getAllEnquiries() {
		// TODO Auto-generated method stub
		return hotelTypesRepo.findAll();
	}

	@Override
	public HotelTypes getEnquiryById(Long Id) {
		// TODO Auto-generated method stub
		return hotelTypesRepo.findById(Id).orElse(null);
	}

	@Override
	public HotelTypes updateHoteType(long id, HotelTypes hotelTypes) {
		// TODO Auto-generated method stub
		HotelTypes hotelTypes2 = hotelTypesRepo.findById(id).orElse(null);
		hotelTypes2.setHtypeName(hotelTypes.getHtypeName());

		hotelTypes2.setMeals(hotelTypes.getMeals());

		hotelTypes2.setMeals(hotelTypes.getMeals());

		return hotelTypesRepo.save(hotelTypes2);
	}

}
