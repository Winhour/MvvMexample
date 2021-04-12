package com.example.mvvmexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmexample.R;
import com.example.mvvmexample.model.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList){

        this.context = context;
        this.movieList = movieList;

    }

    public void setMovieList(List<MovieModel> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.movieList.get(position).getTitle().toString());
        Glide.with(context)
                .load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        if(this.movieList != null){
           return this.movieList.size();
        }

        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView imageView;

        public MyViewHolder(View itemView){
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.titleView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }

}
