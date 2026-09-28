package org.example.bookingservice.clients;

import org.example.bookingservice.models.dto.responses.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie-service", path = "/api/v1/movies")
public interface MovieClient {
    @GetMapping("/{id}")
    MovieResponse getMovieById(@PathVariable Long id);
    @PostMapping
    MovieResponse createMovie(@RequestBody MovieClient movie);
    @GetMapping
    List<MovieResponse> getAllMovies();
    @GetMapping("/search")
    List<MovieResponse> searchMovies(@RequestParam String title);
    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable Long id);
    @PutMapping("/{id}")
    MovieResponse updateMovie(@PathVariable Long id, @RequestBody MovieClient movie);
}
