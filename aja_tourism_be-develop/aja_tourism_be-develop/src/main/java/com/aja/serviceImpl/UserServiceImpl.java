package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.UsersDeleteResponseDto;
import com.aja.Dto.UsersRequestDto;
import com.aja.Dto.UsersResponseDto;
import com.aja.constant.IdentityProofType;
import com.aja.entity.Nationality;
import com.aja.entity.Users;
import com.aja.repository.UsersRepo;
import com.aja.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UsersRepo userRepository;

	@Override
	public UsersResponseDto registerUsers(UsersRequestDto user) {

		UsersResponseDto userRes = new UsersResponseDto();

		// simple validation (NO exception)
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			return null;
		}

		if (userRepository.existsByEmail(user.getEmail())) {
			return null;
		}

		// identity type
		if (user.getNationality() == Nationality.NON_INDIAN) {

			if (user.getIdentityProofType() != IdentityProofType.PASSPORT) {
				return null;
			}

			if (user.getIdentityProofNumber() == null || user.getIdentityProofNumber().trim().isEmpty()) {
				return null;
			}
		}

		Users users = new Users();
		BeanUtils.copyProperties(user, users);

		Users entity = userRepository.save(users);

		BeanUtils.copyProperties(entity, userRes);

		return userRes;
	}

	@Override
	public List<UsersResponseDto> getAllUsers() {

		List<Users> usersList = userRepository.findAll();
		List<UsersResponseDto> resList = new ArrayList<>();

		for (Users user : usersList) {

			UsersResponseDto dtoRes = new UsersResponseDto();
			BeanUtils.copyProperties(user, dtoRes);
			resList.add(dtoRes);
		}

		return resList;
	}

	@Override
	public UsersResponseDto updateUser(Long id, UsersRequestDto user) {

		Optional<Users> updateById = userRepository.findById(id);

		if (updateById.isEmpty()) {
			return null;
		}

		Users users = updateById.get();

		// BeanUtils.copyProperties(user, users, "userId", "password",
		// "confirmPassword");

		if (user.getFullName() != null) {
			users.setFullName(user.getFullName());
		}

		if (user.getMobileNo() != null) {
			users.setMobileNo(user.getMobileNo());
		}

		if (user.getProfileImage() != null) {
			users.setProfileImage(user.getProfileImage());
		}

		Users updated = userRepository.save(users);

		UsersResponseDto userRes = new UsersResponseDto();
		BeanUtils.copyProperties(updated, userRes);

		return userRes;
	}

	@Override
	public UsersResponseDto login(String email, String password) {

		Users user = userRepository.findByEmail(email);

		if (user == null) {
			return null;
		}

		if (!user.getPassword().equals(password)) {
			return null;
		}

		UsersResponseDto userRes = new UsersResponseDto();
		BeanUtils.copyProperties(user, userRes);

		return userRes;
	}

	@Override
	public UsersDeleteResponseDto deleteUser(Long id) {

		Optional<Users> byId = userRepository.findById(id);

		UsersDeleteResponseDto udelRes = new UsersDeleteResponseDto();

		if (byId.isPresent()) {

			Users u = byId.get();
			// soft delete by flag
			u.setFlag(false);
			userRepository.save(u);

			udelRes.setDeleted(true);
			udelRes.setMessage("User Deleted Successfully");

		} else {
			udelRes.setDeleted(false);
			udelRes.setMessage("User Not Deleted Successfully");
		}

		return udelRes;
	}
}
