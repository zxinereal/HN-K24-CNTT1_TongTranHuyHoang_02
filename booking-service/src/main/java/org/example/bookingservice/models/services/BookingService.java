package org.example.bookingservice.models.services;

import org.example.bookingservice.models.dto.requests.CreateBookingRequest;
import org.example.bookingservice.models.dto.responses.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(CreateBookingRequest request);
    List<BookingResponse> findAll();
}
