package com.coracaonamao.favoritos.repositories;

import com.coracaonamao.favoritos.entities.MusicVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicVideoRepository extends JpaRepository<MusicVideo, Long> {

    List<MusicVideo> findAllByTitle(String title);

    List<MusicVideo> findAllByYear(String year);

    List<MusicVideo> findAllByGenre(String genre);

    List<MusicVideo> findAllByBand(String band);

    List<MusicVideo> findAllBySinger(String singer);

    List<MusicVideo> findAllByProject(String project);

    List<MusicVideo> findAllByDirector(String director);
}
