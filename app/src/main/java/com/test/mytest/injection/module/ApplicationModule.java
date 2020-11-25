package com.test.mytest.injection.module;

import android.app.Application;
import android.content.Context;


import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context ContextProvider(){
        return application.getApplicationContext();
    }

}
