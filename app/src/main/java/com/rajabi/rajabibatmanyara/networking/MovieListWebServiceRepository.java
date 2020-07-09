package com.rajabi.rajabibatmanyara.networking;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.rajabi.rajabibatmanyara.models.db.DetailMovieEntity;
import com.rajabi.rajabibatmanyara.models.db.DetailMovieListRoomRepository;
import com.rajabi.rajabibatmanyara.models.db.MovieListEntity;
import com.rajabi.rajabibatmanyara.models.db.MovieListRoomRepository;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MovieListWebServiceRepository {

    Application application;
    final String API_KEY = "3e974fca";

    public MovieListWebServiceRepository(Application application) {
        this.application = application;
    }

    private static OkHttpClient providesOkHttpClientBuilder() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build();

    }


    List<MovieListEntity> webserviceResponseList = new ArrayList<>();
    List<DetailMovieEntity> webserviceDetailResponseList = new ArrayList<>();


    public MutableLiveData<List<MovieListEntity>> providesWebService() {

        final MutableLiveData<List<MovieListEntity>> data = new MutableLiveData<>();

        String response = "";
        try {
//            Retrofit retrofit = getRetrofit();
//            MovieListApiService service = retrofit.create(MovieListApiService.class);
            Retrofit2Client retrofit2Client = Retrofit2Client.getInstance();
            retrofit2Client.getExploreService().getMovies("batman", API_KEY).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    call.request().url();
                    Log.d("Repository", "Response::::" + response.body());
                    webserviceResponseList = parseJson(response.body());
                    MovieListRoomRepository postRoomDBRepository = new MovieListRoomRepository(application);
                    postRoomDBRepository.insertPosts(webserviceResponseList);
                    data.setValue(webserviceResponseList);


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Repository", "Failed:::");
                    call.request().url();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    public MutableLiveData<List<DetailMovieEntity>> providesWebServiceDetail(String imdbID) {

        final MutableLiveData<List<DetailMovieEntity>> data = new MutableLiveData<>();

        try {

            Retrofit2Client retrofit2Client = Retrofit2Client.getInstance();
            retrofit2Client.getExploreService().getDetailMovies(imdbID, API_KEY).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    call.request().url();
                    Log.d("Repository", "Response::::" + response.body());
                    webserviceDetailResponseList = parseJsonDetail(response.body());
                    DetailMovieListRoomRepository postRoomDBRepository = new DetailMovieListRoomRepository(application, imdbID);
                    postRoomDBRepository.insertPosts(webserviceDetailResponseList);
                    data.setValue(webserviceDetailResponseList);


                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Repository", "Failed:::");
                    call.request().url();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

    }

    private List<MovieListEntity> parseJson(String response) {

        List<MovieListEntity> apiResults = new ArrayList<>();


        JSONArray jsonArray;

        try {
            JSONObject obj = new JSONObject(response);
            jsonArray = new JSONArray(obj.getString("Search"));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);

                MovieListEntity mMovieModel = new MovieListEntity();

                mMovieModel.setYear(object.getString("Year"));
                mMovieModel.setType(object.getString("Type"));
                mMovieModel.setImdbID(object.getString("imdbID"));
                mMovieModel.setTitle(object.getString("Title"));
                mMovieModel.setPoster(object.getString("Poster"));

                apiResults.add(mMovieModel);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }

    private List<DetailMovieEntity> parseJsonDetail(String response) {

        List<DetailMovieEntity> apiResults = new ArrayList<>();


        try {
            JSONObject object = new JSONObject(response);


            DetailMovieEntity mMovieModel = new DetailMovieEntity();

            mMovieModel.setYear(object.getString("Year"));
            mMovieModel.setActors(object.getString("Actors"));
            mMovieModel.setImdbID(object.getString("imdbID"));
            mMovieModel.setDirector(object.getString("Director"));
            mMovieModel.setGenre(object.getString("Genre"));
            mMovieModel.setPlot(object.getString("Plot"));
            mMovieModel.setTitle(object.getString("Title"));
            mMovieModel.setPoster(object.getString("Poster"));
            mMovieModel.setRated(object.getString("Rated"));
            mMovieModel.setReleased(object.getString("Released"));
            mMovieModel.setRuntime(object.getString("Runtime"));
            apiResults.add(mMovieModel);


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(getClass().getSimpleName(), String.valueOf(apiResults.size()));
        return apiResults;

    }
}
