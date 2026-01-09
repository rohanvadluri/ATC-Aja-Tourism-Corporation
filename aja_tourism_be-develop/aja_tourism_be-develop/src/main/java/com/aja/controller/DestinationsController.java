package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.DestinationDeleteResponseDto;
import com.aja.Dto.DestinationsRequestDto;
import com.aja.Dto.DestinationsResponseDto;
import com.aja.serviceImpl.DestinationsServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/destinations")
public class DestinationsController {

    @Autowired
    private DestinationsServiceImpl destImpl;

    // ---------------- CREATE ----------------
    @PostMapping("/create")
    public ResponseEntity<DestinationsResponseDto> createDestination(
            @RequestBody DestinationsRequestDto dto) {

        DestinationsResponseDto response = destImpl.addDestination(dto);
        return ResponseEntity.ok(response);
    }

    // ---------------- GET ALL ----------------
    @GetMapping("/all")
    public ResponseEntity<List<DestinationsResponseDto>> getAllDestinations() {

        List<DestinationsResponseDto> list = destImpl.viewAllDestinations();
        return ResponseEntity.ok(list);
    }

    // ---------------- GET BY ID ----------------
    @GetMapping("/{destinationId}")
    public ResponseEntity<DestinationsResponseDto> getDestinationById(
            @PathVariable Long destinationId) {

        DestinationsResponseDto response = destImpl.viewById(destinationId);
        return ResponseEntity.ok(response);
    }

    // ---------------- UPDATE ----------------
    @PutMapping("/update/{destinationId}")
    public ResponseEntity<DestinationsResponseDto> updateDestination(
            @PathVariable Long destinationId,
            @RequestBody DestinationsRequestDto dto) {

        DestinationsResponseDto response =
                destImpl.updateDestination(destinationId, dto);

        return ResponseEntity.ok(response);
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/delete/{destinationId}")
    public ResponseEntity<DestinationDeleteResponseDto> deleteDestination(
            @PathVariable Long destinationId) {

        DestinationDeleteResponseDto response =
                destImpl.deleteDestination(destinationId);

        return ResponseEntity.ok(response);
    }
}
