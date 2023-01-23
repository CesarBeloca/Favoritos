package com.coracaonamao.favoritos.controllers;

import com.coracaonamao.favoritos.dtos.AlbumDto;
import com.coracaonamao.favoritos.entities.Album;
import com.coracaonamao.favoritos.services.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Album> saveAlbum(@RequestBody AlbumDto albumDto) {
        var album = new Album();
        BeanUtils.copyProperties(albumDto, album);
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.save(album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAlbum(@PathVariable(value = "id") Long id) {
        Optional<Album> albumModelOptional = albumService.findByID(id);
        albumService.delete(albumModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Album deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        List<Album> list = albumService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAll());
    }

    @GetMapping(value = "/album/{id}")
    public ResponseEntity<Album> findById(@PathVariable("id") Long id) {
        Album album = albumService.findByID(id).get();
        return ResponseEntity.ok().body(album);
    }

    @GetMapping(value = "/band/{band}")
    public ResponseEntity<List<Album>> findAllByBand(@PathVariable("band") String band) {
        List<Album> listByBand = albumService.findAllByBand(band);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAllByBand(band));
    }


    @GetMapping(value = "/singer/{singer}")
    public ResponseEntity<List<Album>> findAllBySinger(@PathVariable("singer") String singer) {
        List<Album> listBySinger = albumService.findAllBySinger(singer);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAllBySinger(singer));
    }

    @GetMapping(value = "/project/{project}")
    public ResponseEntity<List<Album>> findAllByProject(@PathVariable("project") String project) {
        List<Album> listByProject = albumService.findAllByProject(project);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAllByProject(project));
    }

    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<List<Album>> findAllByGenre(@PathVariable("genre") String genre) {
        List<Album> listByGenre = albumService.findAllByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAllByGenre(genre));
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<Album>> findAllByYear(@PathVariable("year") String year) {
        List<Album> listByYear = albumService.findAllByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAllByYear(year));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAlbum(@PathVariable(value = "id") Long id,
                                              @RequestBody AlbumDto albumDto) {
        Optional<Album> albumOptional = albumService.findByID(id);
        if (!albumOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album not found");
        }
        var album = new Album();
        BeanUtils.copyProperties(albumDto, album);
        album.setId(albumOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(AlbumController.this.albumService.save(album));
    }
}
