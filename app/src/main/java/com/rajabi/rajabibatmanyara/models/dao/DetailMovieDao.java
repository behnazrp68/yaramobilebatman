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
public interface DetailMovieDao {


    @Query("SELECT * from detailmovie where imdbID=:id ORDER BY id ASC")
    LiveData<List<DetailMovieEntity>> getDetailMovie(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetail(DetailMovieEntity... movie);


    default void insertOrUpdateDetail(DetailMovieEntity item) {
        List<DetailMovieEntity> itemsFromDB = getItemById(item.getImdbID());
        if (itemsFromDB.isEmpty())
            insertDetail(item);
    }


    @Query("SELECT * from detailmovie WHERE imdbid= :id")
    List<DetailMovieEntity> getItemById(String id);
}
