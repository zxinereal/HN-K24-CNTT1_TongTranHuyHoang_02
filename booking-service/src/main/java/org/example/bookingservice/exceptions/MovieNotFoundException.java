package org.example.bookingservice.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movieId) {
        super("Movie không tồn tại id: " + movieId);
    }
}
