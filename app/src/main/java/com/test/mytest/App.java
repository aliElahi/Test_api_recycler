package com.test.mytest;

import android.app.Application;

import com.test.mytest.injection.ApplicationComponent;
import com.test.mytest.injection.DaggerApplicationComponent;
import com.test.mytest.injection.module.ApplicationModule;
import com.test.mytest.injection.module.DataModule;
import com.test.mytest.injection.module.ViewModelModule;
import com.test.mytest.injection.module.ViewModule;

public class App  extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .dataModule(new DataModule())
                .applicationModule(new ApplicationModule(this))
                .viewModelModule(new ViewModelModule())
                .viewModule(new ViewModule())
                .build();

    }

    public ApplicationComponent getAppComponent(){
        return component;
    }
}
