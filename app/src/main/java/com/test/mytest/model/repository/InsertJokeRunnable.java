package com.test.mytest.model.repository;

import androidx.annotation.NonNull;

import com.test.mytest.model.database.JokeDao;
import com.test.mytest.model.database.JokeModel;

import java.lang.ref.WeakReference;
import java.util.List;

public class InsertJokeRunnable implements Runnable {

    WeakReference<JokeDao> daoWeakReference;
    List<JokeModel> list;

    private InsertJokeRunnable(JokeDao jokeDao, List<JokeModel> list) {
        this.daoWeakReference = new WeakReference<>(jokeDao);
        this.list = list;
    }


    public static InsertJokeRunnable create (@NonNull JokeDao jokeDao , @NonNull List<JokeModel> list){
        return new InsertJokeRunnable(jokeDao,list);
    }

    @Override
    public void run() {
        try {
            if(daoWeakReference.get() != null){
                daoWeakReference.get().insertListOfJoke(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
