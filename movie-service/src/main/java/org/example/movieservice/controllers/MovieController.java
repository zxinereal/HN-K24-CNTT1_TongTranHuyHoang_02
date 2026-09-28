package org.example.movieservice.controllers;

import org.example.movieservice.models.entities.Movie;
import org.example.movieservice.models.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        return ResponseEntity.ok(movieService.searchMovies(title));
    }
}
