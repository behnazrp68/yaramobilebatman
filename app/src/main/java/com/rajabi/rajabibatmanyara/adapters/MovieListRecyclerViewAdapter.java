package com.rajabi.rajabibatmanyara.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabi.rajabibatmanyara.R;
import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<MovieListEntity> movieArrayList = new ArrayList<>();
    List<DetailMovieEntity> detailMovie = new ArrayList<>();
    private MovieListClickListener mListener;
    private static int TYPE_MOVIE = 1;
    private static int TYPE_DETAIL = 2;

    public MovieListRecyclerViewAdapter(Activity context, MovieListClickListener mListener) {
        this.context = context;
        this.mListener = mListener;
    }

    public MovieListRecyclerViewAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == TYPE_MOVIE) { // for call layout
            view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
            return new MovieListViewHolder(view, mListener);

        } else { // for email layout
            view = LayoutInflater.from(context).inflate(R.layout.detail_item, parent, false);
            return new DetailViewHolder(view);
        }

//
//        View rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
//        return new RecyclerViewViewHolder(rootView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (getItemViewType(position) == TYPE_MOVIE) {
            init(holder, position);
        } else {
            initDetail(holder, position);
        }

    }

    private void init(RecyclerView.ViewHolder holder, int position) {

        MovieListEntity currentMovie = movieArrayList.get(position);
        ((MovieListViewHolder) holder).txtView_title.setText(currentMovie.getTitle().toString());
        ((MovieListViewHolder) holder).txtView_year.setText(currentMovie.getYear());
        ((MovieListViewHolder) holder).txtView_type.setText(currentMovie.getType());

        Picasso.get().load(currentMovie.getPoster()).into(((MovieListViewHolder) holder).imgView_icon);
    }

    @Override
    public int getItemCount() {

        if (mListener != null)
            return movieArrayList.size();
        else
            return detailMovie.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mListener != null) {
            return TYPE_MOVIE;

        } else {
            return TYPE_DETAIL;
        }
    }

    public void setMovieArrayList(List<MovieListEntity> movies) {
        this.movieArrayList = movies;
        notifyDataSetChanged();
    }

    private void initDetail(RecyclerView.ViewHolder holder, int position) {

        DetailMovieEntity currentMovie = detailMovie.get(position);
        ((DetailViewHolder) holder).txtView_title.setText(currentMovie.getTitle());
        ((DetailViewHolder) holder).txtView_awards.setText("Awards : " + currentMovie.getAwards());
        ((DetailViewHolder) holder).txtView_rated.setText(currentMovie.getRated());
        ((DetailViewHolder) holder).txtView_Retained.setText("Rated : " + currentMovie.getRated());
        ((DetailViewHolder) holder).txtView_Actors.setText("Actors : " + currentMovie.getActors());
        ((DetailViewHolder) holder).txtView_Plot.setText(currentMovie.getPlot());
        ((DetailViewHolder) holder).txtView_Genre.setText("Genre : " + currentMovie.getGenre());
        ((DetailViewHolder) holder).txtView_Director.setText("Director : " + currentMovie.getDirector());
        ((DetailViewHolder) holder).txtView_Runtime.setText(currentMovie.getRuntime());
        ((DetailViewHolder) holder).txtView_Released.setText(currentMovie.getReleased());
        Picasso.get().load(currentMovie.getPoster()).into(((DetailViewHolder) holder).imgView_icon);
    }

    public void setDetailMovie(List<DetailMovieEntity> details) {
        this.detailMovie = details;
        notifyDataSetChanged();
    }
}

