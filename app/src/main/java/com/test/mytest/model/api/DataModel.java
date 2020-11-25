package com.test.mytest.model.api;

import com.google.gson.annotations.SerializedName;
import com.test.mytest.model.database.JokeModel;

import java.util.List;

public class DataModel {

    private String type;
    @SerializedName("value")
    private List<JokeModel> list;

    public List<JokeModel> getList() {
        return list;
    }

    public DataModel() {
    }
}
