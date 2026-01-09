package com.aja.service;

import java.util.List;

import com.aja.Dto.StatesDeleteResponseDto;
import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;

public interface StatesService {
	public StatesResponseDto addState(StatesRequestDto sr);
	public List<StatesResponseDto> viewAllStates();
	public StatesResponseDto viewStateById(Long stateId);
	public StatesResponseDto updateState(Long stateId,StatesRequestDto s);
	public StatesDeleteResponseDto deleteState(Long stateId);
}
