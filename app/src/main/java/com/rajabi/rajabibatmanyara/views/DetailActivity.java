package com.rajabi.rajabibatmanyara.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.rajabi.rajabibatmanyara.R;
import com.rajabi.rajabibatmanyara.adapters.MovieListRecyclerViewAdapter;
import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.rajabi.rajabibatmanyara.viewmodels.DetailMovieViewModel;
import com.rajabi.rajabibatmanyara.viewmodels.FactoryViewModel;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    MovieListRecyclerViewAdapter adapter = null;
    View view = null;
    RecyclerView recyclerView;
    DetailMovieViewModel retroViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String imdbID = "";
        if (getIntent() != null && getIntent().getExtras() != null)
            imdbID = getIntent().getExtras().getString("imdbID");
        retroViewModel = new ViewModelProvider(this, new FactoryViewModel(this.getApplication(), imdbID)).get(DetailMovieViewModel.class);
        initViews();
        setAdapter();
        progressDialog = ProgressDialog.show(this, "Loading...", "Please wait...", true);
        retroViewModel.getAllPosts().observe(this, new Observer<List<DetailMovieEntity>>() {
            @Override
            public void onChanged(@Nullable List<DetailMovieEntity> resultModels) {
                adapter.setDetailMovie(resultModels);
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }
        });

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }


    private void setAdapter() {

        adapter = new MovieListRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}