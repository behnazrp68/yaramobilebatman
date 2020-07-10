package com.rajabi.rajabibatmanyara.models.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.rajabi.rajabibatmanyara.models.dao.DetailMovieDao;
import com.rajabi.rajabibatmanyara.models.dao.MovieListDao;


@Database(entities = {MovieListEntity.class, DetailMovieEntity.class}, version = 1)
public abstract class BatmanDatabase extends RoomDatabase {
    public abstract MovieListDao movielistdao();

    public abstract DetailMovieDao detailMovielistdao();

    private static BatmanDatabase INSTANCE;


    public static BatmanDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BatmanDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BatmanDatabase.class, "movie_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };
}



