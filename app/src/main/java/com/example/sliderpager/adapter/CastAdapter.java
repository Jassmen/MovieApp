package com.example.sliderpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sliderpager.models.Cast;
import com.example.sliderpager.R;

import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private Context mContext;
    private List<Cast> mCast;

    public CastAdapter(Context mContext, List<Cast> mCast) {
        this.mContext = mContext;
        this.mCast = mCast;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.cast_item,parent,false);

        return new  CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
       Glide.with(mContext).load(mCast.get(position).getImgLink()).into(holder.castImg);
       // holder.castImg.setImageResource(mCast.get(position).getImgLink());


    }

    @Override
    public int getItemCount() {
        return mCast.size();
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {

        ImageView castImg;

        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            castImg=itemView.findViewById(R.id.cast_image);


        }
    }
}
