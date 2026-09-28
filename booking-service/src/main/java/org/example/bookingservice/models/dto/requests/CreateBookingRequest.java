package org.example.bookingservice.models.dto.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import java.util.List;

public record CreateBookingRequest(
        @NotBlank(message = "Customer name không được để trống")
        @Size(max = 255, message = "Customer name không vượt quá 255 ký tự")
        String customerName,
        @NotBlank(message = "Customer email không để trống")
        @Email(message = "Customer email không hợp lệ")
        String customerEmail,
        @NotEmpty(message = "Booking must không trống")
        List<@Valid CreateBookingDetailRequest> items) {
}
