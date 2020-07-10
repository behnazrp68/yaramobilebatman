package com.rajabi.rajabibatmanyara.models.db;


import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.rajabi.rajabibatmanyara.models.dao.MovieListDao;
import java.util.List;

public class MovieListRoomRepository {
    private MovieListDao movieListDao;
    LiveData<List<MovieListEntity>> mAllPosts;

    public MovieListRoomRepository(Application application) {
        BatmanDatabase db = BatmanDatabase.getDatabase(application);
        movieListDao = db.movielistdao();
        mAllPosts = movieListDao.getAllPosts();
    }

    public LiveData<List<MovieListEntity>> getAllPosts() {
        return mAllPosts;
    }

    public void insertPosts(List<MovieListEntity> resultModel) {

        new insertAsyncTask(movieListDao).execute(resultModel);
    }

    private static class insertAsyncTask extends AsyncTask<List<MovieListEntity>, Void, Void> {

        private MovieListDao mAsyncTaskDao;

        insertAsyncTask(MovieListDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<MovieListEntity>... params) {
            if (params[0] != null)
                for (int i = 0; i < params[0].size(); i++)
                    mAsyncTaskDao.insertOrUpdate(params[0].get(i));
            return null;
        }
    }
}

