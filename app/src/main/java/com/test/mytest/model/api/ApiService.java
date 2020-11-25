package com.test.mytest.model.api;

import javax.inject.Inject;

import retrofit2.Call;

public class ApiService {

    ApiClient apiClient;

    private static final int NUMBER = 10;

    @Inject
    public ApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

     public Call<DataModel> getJokes(){
        return apiClient.getJoke(NUMBER);
    }
}
