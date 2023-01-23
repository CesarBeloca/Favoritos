package com.coracaonamao.favoritos.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ALBUMS")
public class Album implements Serializable {
    @Serial
    private static final  long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALBUM_ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "BAND")
    private String band;
    @Column(name = "SINGER")
    private String singer;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "ALBUM_COVER")
    private String albumCover;
    @Column(name = "REVIEW")
    private String review;

    public Album() {
    }

    public Album(Long id,
                 String title,
                 String band,
                 String singer,
                 String project,
                 String genre,
                 String year,
                 String albumCover,
                 String review) {
        this.id = id;
        this.title = title;
        this.band = band;
        this.singer = singer;
        this.project = project;
        this.genre = genre;
        this.year = year;
        this.albumCover = albumCover;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}




