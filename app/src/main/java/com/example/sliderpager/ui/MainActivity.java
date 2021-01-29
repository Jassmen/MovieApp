package com.example.sliderpager.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.sliderpager.adapter.MovieAdapter;
import com.example.sliderpager.adapter.MovieItemClickListener;
import com.example.sliderpager.models.Movies;
import com.example.sliderpager.R;
import com.example.sliderpager.models.Slide;
import com.example.sliderpager.adapter.SliderAdapter;
import com.example.sliderpager.utils.DataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private List<Movies> lstMovie;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView rcMovies;
    private RecyclerView rvThisWeek;
    private FloatingActionButton playButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        getSupportActionBar().setTitle("MovieApp");
        //Setup animation
       // imgCover.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
       //playButton.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));

        // prepare a list of slides
        slider();

        //Setup Timer
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000,5000);
        //Indicator
        indicator.setupWithViewPager(sliderPager,true);

        /*********RecyclerView ***********/
        popularMovies();
        moviesWeek();


    }

    private void moviesWeek() {
        MovieAdapter weekMovie= new MovieAdapter(this,DataSource.getMoviesWeek(),this);
        rvThisWeek.setAdapter(weekMovie);
        rvThisWeek.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initViews() {
        sliderPager=findViewById(R.id.slider_pager);
        indicator=findViewById(R.id.indicator);
        rcMovies=findViewById(R.id.recycle_movie);
        playButton=findViewById(R.id.floatingActionButton);
        rvThisWeek=findViewById(R.id.recycle_movie_week);
    }

    private void popularMovies() {
        //DataSource : de Function 3mlaha 3lshn a7otha fe aktr mn recyclerView bdl m3od aktb kteer ydob astd3eha

        MovieAdapter movieAdapter=new MovieAdapter(this, DataSource.getPopularMovies(),this);
        rcMovies.setAdapter(movieAdapter);
        rcMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    private void slider() {
        lstSlides=new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.interstellar_ver2_xlg,"Slide title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.inception,"Slide title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.interstellar_ver2_xlg,"Slide title \nmore text here"));
        lstSlides.add(new Slide(R.drawable.inception,"Slide title \nmore text here"));
        SliderAdapter adapter= new SliderAdapter(this,lstSlides);
        sliderPager.setAdapter(adapter);
    }

    // De method ana 3mlaha fl Interface MovieItemClickListener
    @Override
    public void onMovieClick(Movies movie, ImageView imageView) {
        //Send Movie Information To DetailMovie Activity
        //Also we Will Create Transition Animation
        Intent intent=new Intent(this,MovieDetail.class);
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgUrl",movie.getUrlMovie());
        intent.putExtra("imgCover",movie.getUrlCover());

        ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageView,"SharedName");
        startActivity(intent,activityOptions.toBundle());



    }


    /********** Timer For Slider **************/
    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderPager.getCurrentItem() < lstSlides.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }else{
                        sliderPager.setCurrentItem(0);
                    }
                }
            });

        }
    }

}
