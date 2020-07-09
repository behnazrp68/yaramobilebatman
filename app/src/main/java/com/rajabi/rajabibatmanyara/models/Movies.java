package com.rajabi.rajabibatmanyara.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movies {
    @SerializedName("Response")
    @Expose
    private  String Response;

    @SerializedName("totoalResults")
    @Expose
    private int totalResults;

    @SerializedName("Search")
    @Expose
    public List<Search> movies;
}
