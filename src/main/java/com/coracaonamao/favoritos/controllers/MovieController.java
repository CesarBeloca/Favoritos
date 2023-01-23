package com.coracaonamao.favoritos.controllers;

import com.coracaonamao.favoritos.dtos.MovieDto;
import com.coracaonamao.favoritos.entities.Movie;
import com.coracaonamao.favoritos.services.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody MovieDto movieDto) {
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "id") Long id) {
        Optional<Movie> movieModelOptional = movieService.findByID(id);
        movieService.delete(movieModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAll() {
        List<Movie> list = movieService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAll());
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Long id) {
        Movie movie = movieService.findByID(id).get();
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping(value = "/director/{director}")
    public ResponseEntity<List<Movie>> findAllByDirector(@PathVariable("director") String director) {
        List<Movie> listByDirector = movieService.findAllByDirector(director);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAllByDirector(director));
    }

    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<List<Movie>> findAllByGenre(@PathVariable("genre") String genre) {
        List<Movie> listByGenre = movieService.findAllByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAllByGenre(genre));
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<Movie>> findAllByYear(@PathVariable("year") String year) {
        List<Movie> listByYear = movieService.findAllByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAllByYear(year));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable(value = "id") Long id,
                                             @RequestBody MovieDto movieDto) {
        Optional<Movie> movieOptional = movieService.findByID(id);
        if (!movieOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        var movie = new Movie();
        BeanUtils.copyProperties(movieDto, movie);
        movie.setId(movieOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movie));
    }
}
