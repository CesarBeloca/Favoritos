package com.coracaonamao.favoritos.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "MUSIC_VIDEOS")
public class MusicVideo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "M_VID_ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "BAND")
    private String band;
    @Column(name = "SINGER")
    private String singer;
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "LINK")
    private String link;
    @Column(name = "REVIEW")
    private String review;

    public MusicVideo() {
    }

    public MusicVideo(Long id, String title, String band, String singer, String project, String director, String genre, String year, String link, String review) {
        this.id = id;
        this.title = title;
        this.band = band;
        this.singer = singer;
        this.project = project;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.link = link;
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

    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
