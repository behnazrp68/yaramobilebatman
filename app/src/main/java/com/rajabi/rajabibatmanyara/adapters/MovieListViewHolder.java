package com.rajabi.rajabibatmanyara.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabi.rajabibatmanyara.R;

class MovieListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    MovieListClickListener mListener;
    ImageView imgView_icon;
    TextView txtView_title;
    TextView txtView_year;
    TextView txtView_type;

    public MovieListViewHolder(@NonNull View itemView, MovieListClickListener mListener) {
        super(itemView);
        this.mListener = mListener;
        itemView.setOnClickListener(this);
        initViews();


    }

    private void initViews() {

        imgView_icon = itemView.findViewById(R.id.thumbnail);
        imgView_icon.setClickable(false);
        txtView_title = itemView.findViewById(R.id.title);
        txtView_year = itemView.findViewById(R.id.year);
        txtView_type = itemView.findViewById(R.id.type);
    }

    @Override
    public void onClick(View v) {
        mListener.onClick(v, getAdapterPosition());
    }
}

