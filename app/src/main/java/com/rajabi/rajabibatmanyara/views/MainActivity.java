package com.rajabi.rajabibatmanyara.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.rajabi.rajabibatmanyara.R;
import com.rajabi.rajabibatmanyara.adapters.MovieListRecyclerViewAdapter;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;
import com.rajabi.rajabibatmanyara.viewmodels.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MovieListRecyclerViewAdapter adapter = null;
    RecyclerView recyclerView;
    MovieListViewModel retroViewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retroViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        initViews();
        setAdapter();
        progressDialog = ProgressDialog.show(this, "Loading...", "Please wait...", true);
        retroViewModel.getAllPosts().observe(this, new Observer<List<MovieListEntity>>() {
            @Override
            public void onChanged(@Nullable List<MovieListEntity> resultModels) {
                adapter.setMovieArrayList(resultModels);
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

        adapter = new MovieListRecyclerViewAdapter(this, retroViewModel.itemClicked());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}