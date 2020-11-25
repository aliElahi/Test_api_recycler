package com.test.mytest.model.repository;

import androidx.lifecycle.LiveData;

import com.test.mytest.model.api.ApiService;
import com.test.mytest.model.api.DataModel;
import com.test.mytest.model.database.Database;
import com.test.mytest.model.database.JokeDao;
import com.test.mytest.model.database.JokeModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RepositoryImp implements Repository {

    JokeDao jokeDao;
    ApiService service;

    @Inject
    public RepositoryImp(JokeDao jokeDao , ApiService apiService) {
        this.jokeDao = jokeDao;
        this.service = apiService;
    }

    @Override
    public LiveData<List<JokeModel>> getAllJokeModelLiveData() {
        return jokeDao.getAllJokeLiveData();
    }

    @Override
    @EverythingIsNonNull
    public void getJoke() {
        service.getJokes().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.isSuccessful()){
                    Database.getService()
                            .execute(InsertJokeRunnable.create(jokeDao,response.body().getList()));
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteJoke() {
        Database.getService()
                .execute(DeleteAllJokeRunnable.create(jokeDao));
    }
}
