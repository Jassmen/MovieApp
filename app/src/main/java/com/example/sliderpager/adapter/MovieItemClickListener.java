package com.example.sliderpager.adapter;

import android.widget.ImageView;

import com.example.sliderpager.models.Movies;

public interface MovieItemClickListener {

    //Need the ImageView To make the Shared animation between two activity
    void onMovieClick(Movies movie, ImageView imageView);
}
