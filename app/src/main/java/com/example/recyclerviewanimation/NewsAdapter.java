package com.example.recyclerviewanimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context mContext;
    List<NewsItem> mData;    // NewsItem class
    boolean isDark=false;   // dark

    public NewsAdapter(Context mContext, List<NewsItem> mData, boolean isDark) {  // dark
        this.mContext = mContext;
        this.mData = mData;
        this.isDark = isDark;
    }

    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view= LayoutInflater.from(mContext).inflate(R.layout.item_news,parent,false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        // bind data here

        //  we apply animation to views here
        // first lets create  an animatio  for user photo
        holder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

        // Lets create the animation for the whole card
        // first lets create a refrance
        holder.relativeLayout.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));


        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_content.setText(mData.get(position).getContent());
        holder.tv_date.setText(mData.get(position).getDate());
        holder.img_user.setImageResource(mData.get(position).getUserPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title,tv_content,tv_date;
        ImageView img_user;
        RelativeLayout relativeLayout;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout=itemView.findViewById(R.id.relativeLayout);
            tv_title=itemView.findViewById(R.id.tvTitle);
            tv_content=itemView.findViewById(R.id.tvDescription);
            tv_date=itemView.findViewById(R.id.tvDate);
            img_user=itemView.findViewById(R.id.imgUser);

            if (isDark){     // dark
                setDarkTheme();
            }
        }

        private void setDarkTheme(){    // dark
            relativeLayout.setBackgroundResource(R.drawable.card_bg_dark);
        }
    }
}
