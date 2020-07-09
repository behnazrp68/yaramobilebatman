package com.rajabi.rajabibatmanyara.viewmodels;

import android.app.Application;
import android.content.Intent;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rajabi.rajabibatmanyara.adapters.RecyclerViewClickListener;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;
import com.rajabi.rajabibatmanyara.models.db.MovieListRoomRepository;
import com.rajabi.rajabibatmanyara.networking.MovieListWebServiceRepository;
import com.rajabi.rajabibatmanyara.views.DetailActivity;


import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieListRoomRepository postRoomDBRepository;
    private LiveData<List<MovieListEntity>> mAllPosts;
    MovieListWebServiceRepository webServiceRepository;
    private final LiveData<List<MovieListEntity>> retroObservable;

    public MovieListViewModel(Application application) {
        super(application);
        postRoomDBRepository = new MovieListRoomRepository(application);
        webServiceRepository = new MovieListWebServiceRepository(application);
        retroObservable = webServiceRepository.providesWebService();
        mAllPosts = postRoomDBRepository.getAllPosts();

    }

    public LiveData<List<MovieListEntity>> getAllPosts() {
        return mAllPosts;
    }

    public RecyclerViewClickListener itemClicked() {

        RecyclerViewClickListener listener = (view, position) -> {

            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("imdbID", mAllPosts.getValue().get(position).imdbID);
            view.getContext().startActivity(intent);

        };
        return listener;
    }
}
