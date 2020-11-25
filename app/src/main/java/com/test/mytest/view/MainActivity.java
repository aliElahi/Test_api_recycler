package com.test.mytest.view;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.test.mytest.App;
import com.test.mytest.databinding.ActivityMainBinding;
import com.test.mytest.viewModel.MainActivityViewModel;

import javax.inject.Inject;

public class MainActivity
        extends BaseActivity
        implements View.OnClickListener{


    @Inject
    MainAdapter adapter;

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    ViewModelProvider provider;

    MainActivityViewModel viewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialBinding();
    }

    @Override
    void initialBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonClear.setOnClickListener(this);
        binding.buttonNewJoke.setOnClickListener(this);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);

        viewModel.getJokeLiveData()
                .observe(this,jokeModels -> adapter.setList(jokeModels));
    }

    @Override
    void inject() {
        ((App)getApplication())
                .getAppComponent()
                .mainActivityInject(this);
    }

    @Override
    void initialObject() {
        viewModel = provider.get(MainActivityViewModel.class);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.buttonClear){
            viewModel.deleteJokes();
        }
        else if (view == binding.buttonNewJoke){
            viewModel.getNewJoke();
        }
    }
}