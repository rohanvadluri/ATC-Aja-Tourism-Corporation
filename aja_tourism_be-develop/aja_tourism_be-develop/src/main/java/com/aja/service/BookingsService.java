package com.aja.service;

import java.util.List;

import com.aja.Dto.BookingDeleteResponseDto;
import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;

public interface BookingsService {
	

	public BookingsResponseDto addBooking(BookingsRequestDto bres);

	public List<BookingsResponseDto> viewBookings();

	public BookingsResponseDto viewById(Long bookingId);

	public BookingsResponseDto updateBooking(Long bookingId, BookingsRequestDto b);
	
	public BookingDeleteResponseDto deleteBooking(Long bookingId);
}
