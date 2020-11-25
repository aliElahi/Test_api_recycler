package com.test.mytest.model.repository;

import com.test.mytest.model.database.JokeDao;

import java.lang.ref.WeakReference;

public class DeleteAllJokeRunnable implements Runnable{

    private final WeakReference<JokeDao> jokeDao;

    private DeleteAllJokeRunnable(JokeDao jokeDao) {
        this.jokeDao = new WeakReference<>(jokeDao);
    }

    public static DeleteAllJokeRunnable create(JokeDao jokeDao){
        return new DeleteAllJokeRunnable(jokeDao);
    }

    @Override
    public void run() {
        try {
            if (jokeDao != null)
                jokeDao.get().deleteAllJoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
