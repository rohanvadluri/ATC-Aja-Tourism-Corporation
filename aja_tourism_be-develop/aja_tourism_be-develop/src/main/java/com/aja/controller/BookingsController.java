package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.BookingDeleteResponseDto;
import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;
import com.aja.serviceImpl.BookingsServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookingsController {
	@Autowired
	private BookingsServiceImpl bookImpl;
	
	@PostMapping("/create")
	public ResponseEntity<BookingsResponseDto> Booking(@RequestBody BookingsRequestDto b)
	{
		BookingsResponseDto bdto=bookImpl.addBooking(b);
		return ResponseEntity.ok(bdto);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookingsResponseDto>> getAllBookings()
	{
		List<BookingsResponseDto> book =bookImpl.viewBookings();
		return ResponseEntity.ok(book);
		
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingsResponseDto> getBookingById(@PathVariable Long bookingId)
	{
		BookingsResponseDto booking=bookImpl.viewById(bookingId);
		return ResponseEntity.ok(booking);
	}
	
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<BookingsResponseDto> updateBooking(@PathVariable Long bookingId,@RequestBody BookingsRequestDto b)
	{
		BookingsResponseDto res=bookImpl.updateBooking(bookingId, b);
		return ResponseEntity.ok(res);
	}
	@DeleteMapping("/softdelete/{id}")
    public ResponseEntity<BookingDeleteResponseDto> softdelete(@PathVariable Long id) {
    	
	 BookingDeleteResponseDto deleteBooking = bookImpl.deleteBooking(id);
	
		return ResponseEntity.ok(deleteBooking);
	}

	
}
