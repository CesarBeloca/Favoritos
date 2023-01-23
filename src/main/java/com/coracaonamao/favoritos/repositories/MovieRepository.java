package com.coracaonamao.favoritos.repositories;

import com.coracaonamao.favoritos.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByDirector(String director);

    List<Movie> findAllByGenre(String genre);

    List<Movie> findAllByYear(String year);

    List<Movie> findAllByTitle(String title);
}
