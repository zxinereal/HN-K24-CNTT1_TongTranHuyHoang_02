package org.example.movieservice.models.repositories;

import org.example.movieservice.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findById(Long id);

}
