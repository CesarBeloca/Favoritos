package com.coracaonamao.favoritos.services;

import com.coracaonamao.favoritos.entities.MusicVideo;
import com.coracaonamao.favoritos.repositories.MusicVideoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MusicVideosService {

    private final MusicVideoRepository musicVideoRepository;

    public MusicVideosService(MusicVideoRepository musicVideoRepository) {
        this.musicVideoRepository = musicVideoRepository;
    }

    @Transactional
    public MusicVideo save(MusicVideo musicVideo) {
        return this.musicVideoRepository.save(musicVideo);
    }

    public List<MusicVideo> getAll() {
        return musicVideoRepository.findAll();
    }

    public Optional<MusicVideo> findById(Long id) {
        return musicVideoRepository.findById(id);
    }

    @Transactional
    public  void delete(MusicVideo musicVideo) {
        this.musicVideoRepository.delete(musicVideo);
    }

    public List<MusicVideo> findAllByBand(String band) {
        return musicVideoRepository.findAllByBand(band);
    }

    public List<MusicVideo> findAllBySinger(String singer) {
        return musicVideoRepository.findAllBySinger(singer);
    }

    public List<MusicVideo> findAllByProject(String project) {
        return musicVideoRepository.findAllByProject(project);
    }

    public List<MusicVideo> findAllByDirector(String director) { return musicVideoRepository.findAllByDirector(director); }

    public List<MusicVideo> findAllByGenre(String genre) {
        return musicVideoRepository.findAllByGenre(genre);
    }

    public List<MusicVideo> findAllByYear(String year) {
        return musicVideoRepository.findAllByYear(year);
    }
}
