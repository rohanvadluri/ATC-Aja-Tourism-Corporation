package com.aja.service;

import java.util.List;

import com.aja.Dto.DestinationDeleteResponseDto;
import com.aja.Dto.DestinationsRequestDto;
import com.aja.Dto.DestinationsResponseDto;

public interface DestinationsService {

    DestinationsResponseDto addDestination(DestinationsRequestDto dto);

    List<DestinationsResponseDto> viewAllDestinations();

    DestinationsResponseDto viewById(Long destinationId);

    DestinationsResponseDto updateDestination(Long destinationId, DestinationsRequestDto dto);

    DestinationDeleteResponseDto deleteDestination(Long destinationId);
}
