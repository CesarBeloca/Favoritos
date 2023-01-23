package com.coracaonamao.favoritos.controllers;

import com.coracaonamao.favoritos.dtos.MusicVideoDto;
import com.coracaonamao.favoritos.entities.MusicVideo;
import com.coracaonamao.favoritos.services.MusicVideosService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/music_videos")
public class MusicVideoController {

    private final MusicVideosService musicVideosService;

    public MusicVideoController(MusicVideosService musicVideosService) {
        this.musicVideosService = musicVideosService;
    }

    @PostMapping
    public ResponseEntity<MusicVideo> saveMusicVideo(@RequestBody MusicVideoDto musicVideoDto) {
        var musicVideo = new MusicVideo();
        BeanUtils.copyProperties(musicVideoDto, musicVideo);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicVideosService.save(musicVideo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMusicVideo(@PathVariable(value = "id") Long id) {
        Optional<MusicVideo> musicVideoModelOptional = musicVideosService.findById(id);
        musicVideosService.delete(musicVideoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("MusicVideo deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<MusicVideo>> getAll() {
        List<MusicVideo> list = musicVideosService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.getAll());
    }

    @GetMapping(value = "/musicVideo/{id}")
    public ResponseEntity<MusicVideo> findById(@PathVariable("id") Long id) {
        MusicVideo album = musicVideosService.findById(id).get();
        return ResponseEntity.ok().body(album);
    }

    @GetMapping(value = "/band/{band}")
    public ResponseEntity<List<MusicVideo>> findAllByBand(@PathVariable("band") String band) {
        List<MusicVideo> listByBand = musicVideosService.findAllByBand(band);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllByBand(band));
    }


    @GetMapping(value = "/singer/{singer}")
    public ResponseEntity<List<MusicVideo>> findAllBySinger(@PathVariable("singer") String singer) {
        List<MusicVideo> listBySinger = musicVideosService.findAllBySinger(singer);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllBySinger(singer));
    }

    @GetMapping(value = "/project/{project}")
    public ResponseEntity<List<MusicVideo>> findAllByProject(@PathVariable("project") String project) {
        List<MusicVideo> listByProject = musicVideosService.findAllByProject(project);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllByProject(project));
    }

    @GetMapping(value = "/director/{director}")
    public ResponseEntity<List<MusicVideo>> findAllByDirector(@PathVariable("director") String director) {
        List<MusicVideo> listByDirector = musicVideosService.findAllByDirector(director);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllByDirector(director));
    }

    @GetMapping(value = "/genre/{genre}")
    public ResponseEntity<List<MusicVideo>> findAllByGenre(@PathVariable("genre") String genre) {
        List<MusicVideo> listByGenre = musicVideosService.findAllByGenre(genre);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllByGenre(genre));
    }

    @GetMapping(value = "/year/{year}")
    public ResponseEntity<List<MusicVideo>> findAllByYear(@PathVariable("year") String year) {
        List<MusicVideo> listByYear = musicVideosService.findAllByYear(year);
        return ResponseEntity.status(HttpStatus.OK).body(musicVideosService.findAllByYear(year));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMusicVideo(@PathVariable(value = "id") Long id,
                                                   @RequestBody MusicVideoDto musicVideoDto) {
        Optional<MusicVideo> musicVideoOptional = musicVideosService.findById(id);
        if (!musicVideoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MusicVideo not found");
        }
        var musicVideo = new MusicVideo();
        BeanUtils.copyProperties(musicVideoDto, musicVideo);
        musicVideo.setId(musicVideoOptional.get().getId());

        return ResponseEntity.status(HttpStatus.OK).body(MusicVideoController.this.musicVideosService.save(musicVideo));
    }
}
