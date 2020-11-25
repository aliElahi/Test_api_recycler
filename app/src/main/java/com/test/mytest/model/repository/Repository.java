package com.test.mytest.model.repository;

import androidx.lifecycle.LiveData;

import com.test.mytest.model.database.JokeModel;

import java.util.List;

public interface Repository {

    LiveData<List<JokeModel>> getAllJokeModelLiveData();

    void getJoke();

    void deleteJoke();

}
