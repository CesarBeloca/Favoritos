package com.coracaonamao.favoritos.services;

import com.coracaonamao.favoritos.entities.Movie;
import com.coracaonamao.favoritos.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findByID(Long id) {
        return movieRepository.findById(id);
    }

    @Transactional
    public void delete(Movie movie) {
        this.movieRepository.delete(movie);
    }

    public List<Movie> findAllByTitle(String title) {
        return movieRepository.findAllByTitle(title);
    }

    public List<Movie> findAllByDirector(String director) {
        return movieRepository.findAllByDirector(director);
    }

    public List<Movie> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    public List<Movie> findAllByYear(String year) {
        return movieRepository.findAllByYear(year);
    }
}
