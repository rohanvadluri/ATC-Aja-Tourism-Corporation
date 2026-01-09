package com.aja.service;

import java.util.List;

import com.aja.Dto.PlacesDeleteResponseDto;
import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;

public interface PlacesService {
	public PlacesResponseDto addPlace(PlacesRequestDto p);

	public List<PlacesResponseDto> viewAllPlaces();

	public PlacesResponseDto viewPlace(Long placeId);

	public PlacesResponseDto updatePlace(Long placeId, PlacesRequestDto p);
	
	public PlacesDeleteResponseDto deletePlace(Long id);
}
