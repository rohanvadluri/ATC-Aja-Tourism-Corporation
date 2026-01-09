package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.BookingDeleteResponseDto;
import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;
import com.aja.entity.Bookings;
import com.aja.entity.Packages;
import com.aja.entity.Users;
import com.aja.exceptions.InvalidInputException;
import com.aja.exceptions.NoDataFoundException;
import com.aja.exceptions.ResourceNotFoundException;
import com.aja.repository.BookingsRepo;
import com.aja.repository.PackagesRepo;
import com.aja.repository.UsersRepo;
import com.aja.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService {

    @Autowired
    private BookingsRepo bRepo;
    
    @Autowired
    private PackagesRepo pRepo;
    
    @Autowired
    private UsersRepo uRepo;

    // ---------------- ADD ----------------
    @Override
    public BookingsResponseDto addBooking(BookingsRequestDto bres) {

        if (bres == null) {
            throw new InvalidInputException("Booking data cannot be null");
        }

        Bookings booking = new Bookings();
        BeanUtils.copyProperties(bres, booking);
        
        Users user = uRepo.findById(bres.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + bres.getUserId()));
        booking.setUser(user);
 
		Packages packages = pRepo.findById(bres.getPackageId())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Package not found with id: " + bres.getPackageId()));
	    booking.setPackages(packages);

	    Bookings saved = bRepo.save(booking);
        

        BookingsResponseDto response = new BookingsResponseDto();
        BeanUtils.copyProperties(saved, response);
        response.setUserId(saved.getUser().getUserId());
        response.setPackageId(saved.getPackages().getPackageId());
        return response;
    }

    // ---------------- VIEW ALL ----------------
    @Override
    public List<BookingsResponseDto> viewBookings() {

        List<Bookings> list = bRepo.findAll();

        if (list.isEmpty()) {
            throw new NoDataFoundException("No bookings found");
        }

        List<BookingsResponseDto> responseList = new ArrayList<>();

        for (Bookings booking : list) {
            BookingsResponseDto dto = new BookingsResponseDto();
            BeanUtils.copyProperties(booking, dto);
            responseList.add(dto);
        }

        return responseList;
    }

    // ---------------- VIEW BY ID ----------------
    @Override
    public BookingsResponseDto viewById(Long bookingId) {

        Bookings booking = bRepo.findById(bookingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + bookingId));

        BookingsResponseDto response = new BookingsResponseDto();
        BeanUtils.copyProperties(booking, response);
        
        

        return response;
    }

    // ---------------- UPDATE ----------------
    @Override
    public BookingsResponseDto updateBooking(Long bookingId, BookingsRequestDto b) {

        if (b == null) {
            throw new InvalidInputException("Update booking data cannot be null");
        }

        Bookings booking = bRepo.findById(bookingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + bookingId));

        BeanUtils.copyProperties(b, booking, "bookingId");

        Bookings updated = bRepo.save(booking);

        BookingsResponseDto response = new BookingsResponseDto();
        BeanUtils.copyProperties(updated, response);
        response.setUserId(booking.getUser().getUserId());
        response.setPackageId(booking.getPackages().getPackageId());
        return response;
    }

    // ---------------- DELETE (SOFT DELETE) ----------------
    @Override
    public BookingDeleteResponseDto deleteBooking(Long bookingId) {

        Bookings booking = bRepo.findById(bookingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Booking not found with id: " + bookingId));

        booking.setFlag(false); // soft delete
        bRepo.save(booking);

        BookingDeleteResponseDto response = new BookingDeleteResponseDto();
        response.setDeleted(true);
        response.setMessage("Booking deleted successfully");

        return response;
    }
}
