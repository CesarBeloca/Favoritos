package com.coracaonamao.favoritos.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "MOVIES")
public class Movie implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "POSTER")
    private String poster;
    @Column(name = "REVIEW")
    private String review;

    public Movie() {
    }

    public Movie(Long id, String title, String director, String genre, String year, String poster, String review) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.poster = poster;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}

