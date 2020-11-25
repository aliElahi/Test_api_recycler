package com.test.mytest.injection.module;

import android.content.Context;

import com.test.mytest.model.Common;
import com.test.mytest.model.api.ApiService;
import com.test.mytest.model.repository.Repository;
import com.test.mytest.model.repository.RepositoryImp;
import com.test.mytest.model.api.ApiClient;
import com.test.mytest.model.database.Database;
import com.test.mytest.model.database.JokeDao;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ApplicationModule.class})
public class DataModule {

    @Provides
    public Database databaseProvider(Context context){
        return Database.getDatabase(context);
    }

    @Provides
    public JokeDao jokeDaoProvider(Database database){
        return database.getJokeDao();
    }

    @Provides
    public Repository repositoryImpProvider(JokeDao dao , ApiService apiService){
        return new RepositoryImp(dao,apiService);
    }

    @Provides
    public ApiService apiServiceProvider(ApiClient apiClient){
        return new ApiService(apiClient);
    }

    @Provides
    public ApiClient apiClientProvider(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

    @Provides
    public Retrofit retrofitProvider(GsonConverterFactory factory){
        return new Retrofit.Builder()
                .addConverterFactory(factory)
                .baseUrl(Common.BASE_URL)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactoryProvider(){
        return GsonConverterFactory.create();
    }

}
