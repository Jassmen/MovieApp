package com.example.sliderpager.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sliderpager.models.Cast;
import com.example.sliderpager.adapter.CastAdapter;
import com.example.sliderpager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail extends AppCompatActivity {
    private ImageView imgMovie;
    private ImageView imgCover;
    private TextView imgTitle;
    private FloatingActionButton fbPlay;
    private RecyclerView rvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imgMovie=findViewById(R.id.detail_movie_img);
        imgTitle=findViewById(R.id.detail_movie_title);
        imgCover=findViewById(R.id.movie_detail_cover);
        fbPlay=findViewById(R.id.fb_play);
        rvCast =findViewById(R.id.recycle_cast);

    //Initialization
        initViews();

        //RecyclerView For Cast " setup RvCast "
        setupRvCast();
    }



    private void initViews() {


        String movieTitle=getIntent().getExtras().getString("title");
        int imgUrl=getIntent().getExtras().getInt("imgUrl");
        int urlCover=getIntent().getExtras().getInt("imgCover");
        Glide.with(this).load(imgUrl)  .into(imgMovie);
        Glide.with(this).load(urlCover).into(imgCover);

        imgMovie.setImageResource(imgUrl);
        imgCover.setImageResource(urlCover);
        imgTitle.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);

        //Setup animation
        imgCover.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        fbPlay.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
    }
    private void setupRvCast() {

        List<Cast> mCast =new  ArrayList<>();
        mCast.add(new Cast("Angla",R.drawable.image));
        mCast.add(new Cast("Roma",R.drawable.photo));
        mCast.add(new Cast("Nansii",R.drawable.img6));
        mCast.add(new Cast("Roma",R.drawable.img8));
        mCast.add(new Cast("Mazin",R.drawable.face));
        castAdapter=new CastAdapter(this,mCast);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    }

}