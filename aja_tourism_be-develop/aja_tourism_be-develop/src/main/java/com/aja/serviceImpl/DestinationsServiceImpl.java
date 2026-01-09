package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.DestinationDeleteResponseDto;
import com.aja.Dto.DestinationsRequestDto;
import com.aja.Dto.DestinationsResponseDto;
import com.aja.entity.Destinations;
import com.aja.entity.Places;
import com.aja.exceptions.InvalidInputException;
import com.aja.exceptions.NoDataFoundException;
import com.aja.exceptions.ResourceNotFoundException;
import com.aja.repository.DestinationsRepo;
import com.aja.repository.PlacesRepo;
import com.aja.service.DestinationsService;

@Service
public class DestinationsServiceImpl implements DestinationsService {

    @Autowired
    private DestinationsRepo dRepo;

    @Autowired
    private PlacesRepo pRepo;

    // ---------------- ADD ----------------
    @Override
    public DestinationsResponseDto addDestination(DestinationsRequestDto dto) {

        if (dto == null) {
            throw new InvalidInputException("Destination data cannot be null");
        }

        Places place = pRepo.findById(dto.getPlaceId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Place not found with id: " + dto.getPlaceId()));

        Destinations destination = new Destinations();
        BeanUtils.copyProperties(dto, destination);
        destination.setPlace(place);

        Destinations saved = dRepo.save(destination);

        return mapToResponse(saved);
    }

    // ---------------- VIEW ALL ----------------
    @Override
    public List<DestinationsResponseDto> viewAllDestinations() {

        List<Destinations> list = dRepo.findAll();

        if (list.isEmpty()) {
            throw new NoDataFoundException("No destinations found");
        }

        List<DestinationsResponseDto> responseList = new ArrayList<>();

        for (Destinations d : list) {
            responseList.add(mapToResponse(d));
        }

        return responseList;
    }

    // ---------------- VIEW BY ID ----------------
    @Override
    public DestinationsResponseDto viewById(Long destinationId) {

        Destinations destination = dRepo.findById(destinationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Destination not found with id: " + destinationId));

        return mapToResponse(destination);
    }

    // ---------------- UPDATE ----------------
    @Override
    public DestinationsResponseDto updateDestination(Long destinationId, DestinationsRequestDto dto) {

        if (dto == null) {
            throw new InvalidInputException("Update destination data cannot be null");
        }

        Destinations destination = dRepo.findById(destinationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Destination not found with id: " + destinationId));

        Places place = pRepo.findById(dto.getPlaceId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Place not found with id: " + dto.getPlaceId()));

        BeanUtils.copyProperties(dto, destination, "destinationId");
        destination.setPlace(place);

        Destinations updated = dRepo.save(destination);

        return mapToResponse(updated);
    }

    // ---------------- DELETE ----------------
    @Override
    public DestinationDeleteResponseDto deleteDestination(Long destinationId) {

        Destinations destination = dRepo.findById(destinationId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Destination not found with id: " + destinationId));

        dRepo.delete(destination);

        DestinationDeleteResponseDto response = new DestinationDeleteResponseDto();
        response.setDeleted(true);
        response.setMessage("Destination deleted successfully");

        return response;
    }

    // ---------------- COMMON MAPPER ----------------
    private DestinationsResponseDto mapToResponse(Destinations destination) {

        DestinationsResponseDto dto = new DestinationsResponseDto();
        BeanUtils.copyProperties(destination, dto);

        dto.setPlaceId(destination.getPlace().getPlaceId());
        dto.setPlaceName(destination.getPlace().getPlaceName());

        return dto;
    }
}
