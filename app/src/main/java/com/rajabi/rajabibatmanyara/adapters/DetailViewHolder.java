package com.rajabi.rajabibatmanyara.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajabi.rajabibatmanyara.R;

public class DetailViewHolder extends RecyclerView.ViewHolder {

    ImageView imgView_icon;
    TextView txtView_title;
    TextView txtView_year;
    TextView txtView_rated;
    TextView txtView_Genre;
    TextView txtView_Plot;
    TextView txtView_Retained;
    TextView txtView_Actors;
    TextView txtView_Director;
    TextView txtView_Runtime;
    TextView txtView_Released;

    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews();


    }

    private void initViews() {

        imgView_icon = itemView.findViewById(R.id.thumbnail);
        imgView_icon.setClickable(false);
        txtView_title = itemView.findViewById(R.id.title);
        txtView_year = itemView.findViewById(R.id.year);
        txtView_rated = itemView.findViewById(R.id.rated);
        txtView_Actors = itemView.findViewById(R.id.actors);
        txtView_Director = itemView.findViewById(R.id.director);
        txtView_Genre = itemView.findViewById(R.id.genre);
        txtView_Plot = itemView.findViewById(R.id.plot);
        txtView_Retained = itemView.findViewById(R.id.rated);
        txtView_Runtime = itemView.findViewById(R.id.runtime);
        txtView_Released = itemView.findViewById(R.id.released);
    }
}