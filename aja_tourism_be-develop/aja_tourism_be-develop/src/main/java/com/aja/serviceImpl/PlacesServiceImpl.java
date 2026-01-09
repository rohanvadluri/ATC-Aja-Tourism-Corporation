package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PlacesDeleteResponseDto;
import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;
import com.aja.entity.Places;
import com.aja.entity.States;
import com.aja.exceptions.InvalidPlaceDataException;
import com.aja.exceptions.PlaceAlreadyExistsException;
import com.aja.exceptions.PlaceNotFoundException;
import com.aja.repository.PlacesRepo;
import com.aja.repository.StatesRepo;
import com.aja.service.PlacesService;

@Service
public class PlacesServiceImpl implements PlacesService {

    @Autowired
    private PlacesRepo placesRepo;

    @Autowired
    private StatesRepo statesRepo;

    // ADD PLACE
    @Override
    public PlacesResponseDto addPlace(PlacesRequestDto dto) {

        if (placesRepo.existsByPlaceNameIgnoreCase(dto.getPlaceName())) {
            throw new PlaceAlreadyExistsException(
                    "Place already exists with name: " + dto.getPlaceName());
        }

        States state = statesRepo.findById(dto.getStateId())
                .orElseThrow(() ->
                        new InvalidPlaceDataException("Invalid state id"));

        Places place = new Places();
        place.setPlaceName(dto.getPlaceName());
        place.setDescription(dto.getDescription());
        place.setState(state);

        Places saved = placesRepo.save(place);

        PlacesResponseDto res = new PlacesResponseDto();
        BeanUtils.copyProperties(saved, res);

        return res;
    }

    // VIEW ALL PLACES (ONLY ACTIVE)
    @Override
    public List<PlacesResponseDto> viewAllPlaces() {

        List<Places> placesList = placesRepo.findByIsFlagTrue();
        List<PlacesResponseDto> responseList = new ArrayList<>();

        for (Places place : placesList) {
            PlacesResponseDto dto = new PlacesResponseDto();
            BeanUtils.copyProperties(place, dto);
            responseList.add(dto);
        }

        return responseList;
    }

    // GET PLACE BY ID
    @Override
    public PlacesResponseDto viewPlace(Long placeId) {

        Places place = placesRepo.findById(placeId)
                .orElseThrow(() ->
                        new PlaceNotFoundException(
                                "Place not found with id: " + placeId));

        PlacesResponseDto dto = new PlacesResponseDto();
        BeanUtils.copyProperties(place, dto);

        return dto;
    }

    // UPDATE PLACE
    @Override
    public PlacesResponseDto updatePlace(Long placeId, PlacesRequestDto dto) {

        Places place = placesRepo.findById(placeId)
                .orElseThrow(() ->
                        new PlaceNotFoundException(
                                "Cannot update. Place not found"));

        place.setPlaceName(dto.getPlaceName());
        place.setDescription(dto.getDescription());

        Places updated = placesRepo.save(place);

        PlacesResponseDto res = new PlacesResponseDto();
        BeanUtils.copyProperties(updated, res);

        return res;
    }

    // SOFT DELETE PLACE
    @Override
    public PlacesDeleteResponseDto deletePlace(Long id) {

        Places place = placesRepo.findById(id)
                .orElseThrow(() ->
                        new PlaceNotFoundException(
                                "Cannot delete. Place not found"));

        place.setIsFlag(false);
        placesRepo.save(place);

        PlacesDeleteResponseDto res = new PlacesDeleteResponseDto();
        res.setDeleted(true);
        res.setMessage("Place deleted successfully");

        return res;
    }
}
