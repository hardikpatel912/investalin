package com.investallign.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.activities.NewsDetailsActivity;
import com.investallign.entities.NewsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 2/12/16.
 */
public class NewsFragmentAdapter extends RecyclerView.Adapter<NewsFragmentAdapter.MyViewHolder> {

    private List<NewsEntity> newsEntities;
    Context context;
    private View itemView;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNewsTitle, txtNewsCountry, txtDuration, txtDescription;
        public ImageView ivNews;

        public MyViewHolder(View view) {
            super(view);
            txtNewsTitle = (TextView) view.findViewById(R.id.recycle_row_news_fragment_news_title);
            txtNewsCountry = (TextView) view.findViewById(R.id.recycle_row_news_fragment_news_country);
            txtDuration = (TextView) view.findViewById(R.id.recycle_row_news_fragment_news_duration);
            txtDescription = (TextView) view.findViewById(R.id.recycle_row_news_fragment_news_description);
            ivNews = (ImageView)view.findViewById(R.id.recycle_row_news_fragment_news_image);
        }
    }


    public NewsFragmentAdapter(List<NewsEntity> newsEntities, Context context) {
        this.context = context;
        this.newsEntities = newsEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row_news_fragment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         final NewsEntity newsEntity = newsEntities.get(position);
        holder.txtNewsTitle.setText(newsEntity.getNewsTitle());
        holder.txtNewsCountry.setText(newsEntity.getCountryName());
        holder.txtDuration.setText(newsEntity.getDuration());
        holder.txtDescription.setText(newsEntity.getDescription());

        Picasso.with(context)
                .load(newsEntity.getImgUrl())
                .into(holder.ivNews);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailsActivity.class);
                intent.putExtra("TITLE",newsEntity.getNewsTitle());
                intent.putExtra("COUNTRY",newsEntity.getCountryName());
                intent.putExtra("DURATION",newsEntity.getDuration());
                intent.putExtra("DESCRIPTION",newsEntity.getDescription());
                intent.putExtra("URL",newsEntity.getImgUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsEntities.size();
    }
}
