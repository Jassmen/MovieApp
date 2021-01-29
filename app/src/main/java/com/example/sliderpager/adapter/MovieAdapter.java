package com.example.sliderpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sliderpager.models.Movies;
import com.example.sliderpager.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    List<Movies> mMovie;
    MovieItemClickListener movieItemClickListener;   // from the interface

    public MovieAdapter(Context mContext, List<Movies> mMovie,MovieItemClickListener movieItemClickListener) {
        this.mContext = mContext;
        this.mMovie = mMovie;
        this.movieItemClickListener=movieItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mMovie.get(position).getTitle());
        holder.movieImg.setImageResource(mMovie.get(position).getUrlMovie());

    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView movieImg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.movie_item_title);
            movieImg=itemView.findViewById(R.id.movie_item_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(mMovie.get(getAdapterPosition()),movieImg);
                }
            });
        }
    }
}
