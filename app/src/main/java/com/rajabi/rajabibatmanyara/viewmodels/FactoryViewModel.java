package com.rajabi.rajabibatmanyara.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class FactoryViewModel implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;


    public FactoryViewModel(Application application, String param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new DetailMovieViewModel(mApplication, mParam);
    }
}
