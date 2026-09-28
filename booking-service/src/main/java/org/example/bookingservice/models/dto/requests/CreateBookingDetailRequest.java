package org.example.bookingservice.models.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateBookingDetailRequest(
        @NotNull(message = "Movie không được để trống")
        @Min(value = 1, message = "Movie phải lớn hơn 0")
        Long movieId,

        @NotNull(message = "Quantity không để trống")
        @Min(value = 1, message = "Quantity phải lớn hơn 0")
        Integer quantity
) {
}
