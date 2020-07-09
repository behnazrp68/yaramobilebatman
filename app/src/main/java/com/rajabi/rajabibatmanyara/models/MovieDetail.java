package com.rajabi.rajabibatmanyara.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDetail {

    @SerializedName("Title")
    @Expose
    private String Title;

    @SerializedName("Year")
    @Expose
    private String Year;

    @SerializedName("Rated")
    @Expose
    private String Rated;

    @SerializedName("Released")
    @Expose
    private String Released;

    @SerializedName("Poster")
    @Expose
    private String Poster;


    @SerializedName("Runtime")
    @Expose
    private String Runtime;

    @SerializedName("Genre")
    @Expose
    private String Genre;

    @SerializedName("Director")
    @Expose
    private String Director;

    @SerializedName("Writer")
    @Expose
    private String Writer;

    @SerializedName("Actors")
    @Expose
    private String Actors;


    @SerializedName("Plot")
    @Expose
    private String Plot;

    @SerializedName("Language")
    @Expose
    private String Language;

    @SerializedName("Country")
    @Expose
    private String Country;


    @SerializedName("Awards")
    @Expose
    private String Awards;

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

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
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

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }
}
