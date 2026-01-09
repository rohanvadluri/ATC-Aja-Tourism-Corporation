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

import com.aja.Dto.PackageDeleteResponseDto;
import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;
import com.aja.service.PackageService;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin("*")
public class PackagesController {

	@Autowired
	private PackageService packageService;

	@PostMapping("/create")
	public ResponseEntity<PackagesResponseDto> createPackage(@RequestBody PackagesRequestDto p) {

		PackagesResponseDto pack = packageService.addPackage(p);
		return ResponseEntity.ok(pack);
	}

	@GetMapping("/all")
	public ResponseEntity<List<PackagesResponseDto>> fetchAll() {

		List<PackagesResponseDto> packages = packageService.viewPackages();
		return ResponseEntity.ok(packages);
	}

	@GetMapping("/{packageId}")
	public ResponseEntity<PackagesResponseDto> getPackage(@PathVariable Long packageId) {

		PackagesResponseDto ps = packageService.getPackage(packageId);
		return ResponseEntity.ok(ps);
	}

	@PutMapping("/{packageId}")
	public ResponseEntity<PackagesResponseDto> update(@PathVariable Long packageId, @RequestBody PackagesRequestDto p) {

		return ResponseEntity.ok(packageService.updatePackage(packageId, p));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PackageDeleteResponseDto> deletePackage(@PathVariable Long id) {

		PackageDeleteResponseDto deletePackage = packageService.deletePackage(id);

		return ResponseEntity.ok(deletePackage);
	}
}
