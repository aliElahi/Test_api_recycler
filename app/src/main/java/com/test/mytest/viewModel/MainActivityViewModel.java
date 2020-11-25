package com.test.mytest.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.test.mytest.model.repository.Repository;
import com.test.mytest.model.database.JokeModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    Repository repository;

    public MainActivityViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<JokeModel>> getJokeLiveData(){
        return repository.getAllJokeModelLiveData();
    }

    public void getNewJoke(){
        repository.getJoke();
    }

    public void deleteJokes(){
        repository.deleteJoke();
    }
}
