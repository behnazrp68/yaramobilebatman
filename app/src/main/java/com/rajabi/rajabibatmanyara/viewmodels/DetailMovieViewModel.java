package com.rajabi.rajabibatmanyara.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.rajabi.rajabibatmanyara.models.db.DetailMovieListRoomRepository;
import com.rajabi.rajabibatmanyara.networking.MovieListWebServiceRepository;

import java.util.List;

public class DetailMovieViewModel extends AndroidViewModel {
    private DetailMovieListRoomRepository postRoomDBRepository;
    private LiveData<List<DetailMovieEntity>> mAllPosts;
    MovieListWebServiceRepository webServiceRepository;
    private final LiveData<List<DetailMovieEntity>> retroObservable;

    public DetailMovieViewModel(Application application,String imdbID) {
        super(application);
        postRoomDBRepository = new DetailMovieListRoomRepository(application,imdbID);
        webServiceRepository = new MovieListWebServiceRepository(application);
        retroObservable = webServiceRepository.providesWebServiceDetail(imdbID);
        mAllPosts = postRoomDBRepository.getAllPosts();

    }

    public LiveData<List<DetailMovieEntity>> getAllPosts() {
        return mAllPosts;
    }


}

