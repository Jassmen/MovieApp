package com.example.sliderpager.utils;

import com.example.sliderpager.R;
import com.example.sliderpager.models.Movies;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movies> getPopularMovies(){
       List<Movies> lstMovie=new ArrayList<>();
        lstMovie.add(new Movies(R.drawable.avengers,R.drawable.img5,"Avengers"));
        lstMovie.add(new Movies(R.drawable.io,R.drawable.img6,"IO Movie"));
        lstMovie.add(new Movies(R.drawable.joker,"Joker"));
        lstMovie.add(new Movies(R.drawable.panters,"Painters"));
        lstMovie.add(new Movies(R.drawable.img1,"1927 Movie"));
        lstMovie.add(new Movies(R.drawable.img2,"Black Mirror"));
        lstMovie.add(new Movies(R.drawable.img3,"Big Movie"));
        lstMovie.add(new Movies(R.drawable.img4,"Ingl Urious"));
        lstMovie.add(new Movies(R.drawable.panters,"Painters"));

        return lstMovie;
    }


    public static List<Movies> getMoviesWeek(){
        List<Movies> lstMovie=new ArrayList<>();
        lstMovie.add(new Movies(R.drawable.img4,"Ingl Urious"));
        lstMovie.add(new Movies(R.drawable.avengers,R.drawable.img5,"Avengers"));
        lstMovie.add(new Movies(R.drawable.io,R.drawable.img6,"IO Movie"));
        lstMovie.add(new Movies(R.drawable.joker,"Joker"));
        lstMovie.add(new Movies(R.drawable.panters,"Painters"));
        lstMovie.add(new Movies(R.drawable.panters,"Painters"));
        lstMovie.add(new Movies(R.drawable.img1,"1927 Movie"));
        lstMovie.add(new Movies(R.drawable.panters,"Painters"));
        lstMovie.add(new Movies(R.drawable.img2,"Black Mirror"));
        lstMovie.add(new Movies(R.drawable.img3,"Big Movie"));



        return lstMovie;
    }
}
