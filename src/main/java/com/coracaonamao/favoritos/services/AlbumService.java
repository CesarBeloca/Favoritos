package com.coracaonamao.favoritos.services;

import com.coracaonamao.favoritos.entities.Album;
import com.coracaonamao.favoritos.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Transactional
    public Album save(Album album) {
        return this.albumRepository.save(album);
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Optional<Album> findByID(Long id) {return albumRepository.findById(id);}

    @Transactional
    public void delete(Album album) {
        this.albumRepository.delete(album);
    }

    public List<Album> findAllByTitle(String title) {
        return albumRepository.findAllByTitle(title);
    }

    public List<Album> findAllByBand(String band) {
        return albumRepository.findAllByBand(band);
    }

    public List<Album> findAllBySinger(String singer) { return albumRepository.findAllBySinger(singer);}

    public List<Album> findAllByProject(String project) { return albumRepository.findAllByProject(project);}

    public List<Album> findAllByGenre(String genre) { return albumRepository.findAllByGenre(genre);}

    public List<Album> findAllByYear(String year) { return albumRepository.findAllByYear(year);}
}
