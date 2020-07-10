package com.rajabi.rajabibatmanyara.models.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "detailmovie")
public class DetailMovieEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String Title;

    @ColumnInfo(name = "year")
    public String Year;


    @ColumnInfo(name = "rated")
    public String Rated;

    @ColumnInfo(name = "released")
    public String Released;


    @ColumnInfo(name = "poster")
    public String Poster;


    @ColumnInfo(name = "runtime")
    public String Runtime;

    @ColumnInfo(name = "genre")
    public String Genre;


    @ColumnInfo(name = "director")
    public String Director;

    @ColumnInfo(name = "writer")
    public String Writer;


    @ColumnInfo(name = "actors")
    public String Actors;


    @ColumnInfo(name = "plot")
    public String Plot;

    @ColumnInfo(name = "imdbID")
    public String imdbID;

    @ColumnInfo(name = "awards")
    public String awards;

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }


    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}


