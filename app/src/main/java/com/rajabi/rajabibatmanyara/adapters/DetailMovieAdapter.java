package com.rajabi.rajabibatmanyara.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabi.rajabibatmanyara.R;
import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<DetailMovieEntity> detailMovie = new ArrayList<>();

    public DetailMovieAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.detail_item, parent, false);
        return new DetailViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        init(holder, position);

    }

    private void init(RecyclerView.ViewHolder holder, int position) {

        DetailMovieEntity currentMovie = detailMovie.get(position);
        ((DetailViewHolder) holder).txtView_title.setText(currentMovie.getTitle());
        ((DetailViewHolder) holder).txtView_year.setText(currentMovie.getYear());
        ((DetailViewHolder) holder).txtView_rated.setText(currentMovie.getActors());
        ((DetailViewHolder) holder).txtView_Retained.setText(currentMovie.getRated());
        ((DetailViewHolder) holder).txtView_Actors.setText(currentMovie.getDirector());
        ((DetailViewHolder) holder).txtView_Plot.setText(currentMovie.getPlot());
        ((DetailViewHolder) holder).txtView_Genre.setText(currentMovie.getGenre());
        ((DetailViewHolder) holder).txtView_Director.setText(currentMovie.getDirector());
        ((DetailViewHolder) holder).txtView_Runtime.setText(currentMovie.getRuntime());
        ((DetailViewHolder) holder).txtView_Released.setText(currentMovie.getReleased());
        Picasso.get().load(currentMovie.getPoster()).into(((DetailViewHolder) holder).imgView_icon);
    }

    @Override
    public int getItemCount() {
        return detailMovie.size();
    }

    public void setDetailMovie(List<DetailMovieEntity> details) {
        this.detailMovie = details;
        notifyDataSetChanged();
    }

}


