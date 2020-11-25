package com.test.mytest.injection.module;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.test.mytest.view.MainAdapter;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApplicationModule.class})
public class ViewModule {

    @Provides
    public MainAdapter mainAdapterProvider(){
        return new MainAdapter();
    }

    @Provides
    public LinearLayoutManager layoutManagerProvider(Context context){
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }
}
