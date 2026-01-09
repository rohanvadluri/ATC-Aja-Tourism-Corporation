package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.StatesDeleteResponseDto;
import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;
import com.aja.entity.States;
import com.aja.exceptions.InvalidInputException;
import com.aja.exceptions.NoDataFoundException;
import com.aja.exceptions.ResourceNotFoundException;
import com.aja.repository.StatesRepo;
import com.aja.service.StatesService;

@Service
public class StatesServiceImpl implements StatesService {

    @Autowired
    private StatesRepo sRepo;

    // ---------------- ADD ----------------
    @Override
    public StatesResponseDto addState(StatesRequestDto sr) {

        if (sr == null) {
            throw new InvalidInputException("State data cannot be null");
        }

        States state = new States();
        BeanUtils.copyProperties(sr, state);

        States saved = sRepo.save(state);

        StatesResponseDto response = new StatesResponseDto();
        BeanUtils.copyProperties(saved, response);

        return response;
    }

    // ---------------- VIEW ALL ----------------
    @Override
    public List<StatesResponseDto> viewAllStates() {

        List<States> statesList = sRepo.findAll();

        if (statesList.isEmpty()) {
            throw new NoDataFoundException("No states found");
        }

        List<StatesResponseDto> responseList = new ArrayList<>();

        for (States state : statesList) {
            StatesResponseDto dto = new StatesResponseDto();
            BeanUtils.copyProperties(state, dto);
            responseList.add(dto);
        }

        return responseList;
    }

    // ---------------- VIEW BY ID ----------------
    @Override
    public StatesResponseDto viewStateById(Long stateId) {

        States state = sRepo.findById(stateId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("State not found with id: " + stateId));

        StatesResponseDto response = new StatesResponseDto();
        BeanUtils.copyProperties(state, response);

        return response;
    }

    // ---------------- UPDATE ----------------
    @Override
    public StatesResponseDto updateState(Long stateId, StatesRequestDto dto) {

        if (dto == null) {
            throw new InvalidInputException("Update state data cannot be null");
        }

        States state = sRepo.findById(stateId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("State not found with id: " + stateId));

        BeanUtils.copyProperties(dto, state);

        States updated = sRepo.save(state);

        StatesResponseDto response = new StatesResponseDto();
        BeanUtils.copyProperties(updated, response);

        return response;
    }

    // ---------------- DELETE (SOFT DELETE) ----------------
    @Override
    public StatesDeleteResponseDto deleteState(Long stateId) {

        States state = sRepo.findById(stateId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("State not found with id: " + stateId));

        state.setFlag(false); // soft delete
        sRepo.save(state);

        StatesDeleteResponseDto response = new StatesDeleteResponseDto();
        response.setDeleted(true);
        response.setMessage("State deleted successfully");

        return response;
    }
}
