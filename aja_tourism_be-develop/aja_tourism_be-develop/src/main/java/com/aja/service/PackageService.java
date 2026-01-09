package com.aja.service;

import java.util.List;

import com.aja.Dto.PackageDeleteResponseDto;
import com.aja.Dto.PackagesRequestDto;
import com.aja.Dto.PackagesResponseDto;

public interface PackageService {

	public PackagesResponseDto addPackage(PackagesRequestDto dto);

	public List<PackagesResponseDto> viewPackages();

	public PackagesResponseDto getPackage(Long packageId);

	public PackagesResponseDto updatePackage(Long packageId, PackagesRequestDto dto);

	public PackageDeleteResponseDto deletePackage(Long id);

}
