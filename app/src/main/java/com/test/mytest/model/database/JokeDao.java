package com.test.mytest.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface JokeDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertListOfJoke(List<JokeModel> models);

    @Query("DELETE FROM JokeModel")
    void deleteAllJoke();


    @Query("SELECT * FROM JokeModel")
    LiveData<List<JokeModel>> getAllJokeLiveData();
}
