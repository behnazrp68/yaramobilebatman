package com.rajabi.rajabibatmanyara.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;

import java.util.List;

@Dao
public interface MovieListDao {

    @Query("SELECT * from movieslist ORDER BY id ASC")
    LiveData<List<MovieListEntity>> getAllPosts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieListEntity... movies);


    @Query("SELECT * from movieslist WHERE imdbid= :id")
    List<MovieListEntity> getItemById(String id);


    default void insertOrUpdate(MovieListEntity item) {
        List<MovieListEntity> itemsFromDB = getItemById(item.getImdbID());
        if (itemsFromDB.isEmpty())
            insert(item);

    }


}









