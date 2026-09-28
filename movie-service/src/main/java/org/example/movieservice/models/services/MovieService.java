package org.example.movieservice.models.services;

import org.example.movieservice.models.entities.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);
    Movie createMovie(Movie movie);
    List<Movie> getAllMovies();
    List<Movie> searchMovies(String title);
}
