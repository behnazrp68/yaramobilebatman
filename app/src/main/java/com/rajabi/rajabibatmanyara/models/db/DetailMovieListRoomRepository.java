package com.rajabi.rajabibatmanyara.models.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.rajabi.rajabibatmanyara.models.dao.DetailMovieDao;

import java.util.List;

public class DetailMovieListRoomRepository {
    private DetailMovieDao movieListDao;
    LiveData<List<DetailMovieEntity>> mAllPosts;

    public DetailMovieListRoomRepository(Application application, String imdbID) {
        BatmanDatabase db = BatmanDatabase.getDatabase(application);
        movieListDao = db.detailMovielistdao();
        mAllPosts = movieListDao.getDetailMovie(imdbID);
    }

    public LiveData<List<DetailMovieEntity>> getAllPosts() {
        return mAllPosts;
    }

    public void insertPosts(List<DetailMovieEntity> resultModel) {

        new DetailMovieListRoomRepository.insertAsyncTask(movieListDao).execute(resultModel);
    }

    private static class insertAsyncTask extends AsyncTask<List<DetailMovieEntity>, Void, Void> {

        private DetailMovieDao mAsyncTaskDao;

        insertAsyncTask(DetailMovieDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<DetailMovieEntity>... params) {
            if (params[0] != null)
                for (int i = 0; i < params[0].size(); i++)
                    mAsyncTaskDao.insertOrUpdateDetail(params[0].get(i));

            return null;
        }
    }

}
