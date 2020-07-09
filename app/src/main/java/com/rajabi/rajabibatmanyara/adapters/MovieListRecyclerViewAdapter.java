package com.rajabi.rajabibatmanyara.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabi.rajabibatmanyara.R;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<MovieListEntity> movieArrayList = new ArrayList<>();
    private RecyclerViewClickListener mListener;

    public MovieListRecyclerViewAdapter(Activity context, RecyclerViewClickListener mListener) {
        this.context = context;
        this.mListener = mListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewViewHolder(rootView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        init(holder, position);

    }

    private void init(RecyclerView.ViewHolder holder, int position) {

        MovieListEntity currentMovie = movieArrayList.get(position);
        ((RecyclerViewViewHolder) holder).txtView_title.setText(currentMovie.getTitle().toString());
        ((RecyclerViewViewHolder) holder).txtView_year.setText(currentMovie.getYear());
        ((RecyclerViewViewHolder) holder).txtView_type.setText(currentMovie.getType());

        Picasso.get().load(currentMovie.getPoster()).into(((RecyclerViewViewHolder) holder).imgView_icon);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public void setMovieArrayList(List<MovieListEntity> movies) {
        this.movieArrayList = movies;
        notifyDataSetChanged();
    }

}

