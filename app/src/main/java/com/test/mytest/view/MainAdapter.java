package com.test.mytest.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.mytest.databinding.LayoutMainAdapterBinding;
import com.test.mytest.model.database.JokeModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<JokeModel> list;

    public MainAdapter() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutMainAdapterBinding binding = LayoutMainAdapterBinding.inflate(inflater,parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<JokeModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LayoutMainAdapterBinding binding;
        static final String separator = " , ";

        public ViewHolder(LayoutMainAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(JokeModel jokeModel){
            String category = "";

            binding.textViewJoke.setText(jokeModel.getJoke());

            StringBuilder builder = new StringBuilder();

            if(jokeModel.getCategories() != null){
                for (String s :jokeModel.getCategories()) {
                    builder.append(s);
                    builder.append(separator);
                }

                category = builder.toString();
                int i = category.lastIndexOf(separator);

                if(i >= 0)
                    category = category.substring(0,i);

            }

             binding.textViewCategory.setText(category);

        }
    }
}
