package com.test.mytest.injection;

import com.test.mytest.injection.module.DataModule;
import com.test.mytest.injection.module.ViewModelModule;
import com.test.mytest.injection.module.ViewModule;
import com.test.mytest.view.MainActivity;


import dagger.Component;


@Component(modules = {DataModule.class,
        ViewModule.class,
        ViewModelModule.class})
public interface ApplicationComponent {

    void mainActivityInject(MainActivity mainActivity);

}
