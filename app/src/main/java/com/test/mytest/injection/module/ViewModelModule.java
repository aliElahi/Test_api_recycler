package com.test.mytest.injection.module;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import com.test.mytest.model.repository.Repository;
import com.test.mytest.viewModel.ViewModelFactory;


import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    public ViewModelFactory viewModelFactoryProvider(Repository repository){
        return new ViewModelFactory(repository);
    }

    @Provides
    public static ViewModelProvider viewModelProviderProvider(ViewModelStore store,ViewModelFactory factory){
        return new ViewModelProvider(store,factory);
    }

    @Provides
    public static ViewModelStore store(){
        return new ViewModelStore();
    }


}
