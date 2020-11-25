package com.test.mytest.model.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity
public class JokeModel {

    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("joke")
    private String joke;

    private StringList categories;


    public JokeModel(int id, String joke, StringList categories) {
        this.id = id;
        this.joke = joke;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public StringList getCategories() {
        return categories;
    }

    public void setCategories(StringList categories) {
        this.categories = categories;
    }
}
