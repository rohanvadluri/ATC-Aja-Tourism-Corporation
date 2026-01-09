package com.aja.service;

import java.util.List;

import com.aja.Dto.UsersDeleteResponseDto;
import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;

public interface UsersService {

	public UsersResponseDto registerUsers(UsersRequestDto user);

	public List<UsersResponseDto> getAllUsers();

	public UsersResponseDto login(String email, String password);

	public UsersResponseDto updateUser(Long id, UsersRequestDto user);

	// SOFT DELETE
	public UsersDeleteResponseDto deleteUser(Long id);
}
