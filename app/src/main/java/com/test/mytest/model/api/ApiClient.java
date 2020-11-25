package com.test.mytest.model.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("jokes/random/{number}")
    Call<DataModel> getJoke(@Path("number") int number);
}
