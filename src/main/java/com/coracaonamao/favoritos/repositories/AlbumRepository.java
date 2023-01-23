package com.coracaonamao.favoritos.repositories;

import com.coracaonamao.favoritos.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findAllByTitle(String title);

    List<Album> findAllByYear(String year);

    List<Album> findAllByGenre(String genre);

    List<Album> findAllByBand(String band);

    List<Album> findAllBySinger(String singer);

    List<Album> findAllByProject(String project);
}
