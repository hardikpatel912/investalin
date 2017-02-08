package com.investallign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.investallign.entities.ProfileEntity;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.entities.NewsEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 2/12/16.
 */
public class ProfileFragmentAdapter extends RecyclerView.Adapter<ProfileFragmentAdapter.MyViewHolder> {

    private List<ProfileEntity> profileEntities;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMonthName, txtRate;
        public LinearLayout linearLayoutbackground;

        public MyViewHolder(View view) {
            super(view);
            txtMonthName = (TextView) view.findViewById(R.id.recycle_row_profile_fragment_month);
            txtRate = (TextView) view.findViewById(R.id.recycle_row_profile_fragment_rate);
            linearLayoutbackground = (LinearLayout) view.findViewById(R.id.recycle_row_profile_fragment_layout);
        }
    }


    public ProfileFragmentAdapter(List<ProfileEntity> profileEntities, Context context) {
        this.context = context;
        this.profileEntities = profileEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row_profile_fragment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProfileEntity profileEntity = profileEntities.get(position);
        holder.txtMonthName.setText(profileEntity.getMonth());
        holder.txtRate.setText(context.getResources().getString(R.string.Rs) + profileEntity.getRate());
        if (profileEntity.getBgColor().equalsIgnoreCase("orange")) {
            holder.linearLayoutbackground.setBackgroundColor(context.getResources().getColor(R.color.orange));
        } else if(profileEntity.getBgColor().equalsIgnoreCase("green")){
            holder.linearLayoutbackground.setBackgroundColor(context.getResources().getColor(R.color.green));
        }else{
            holder.linearLayoutbackground.setBackgroundColor(context.getResources().getColor(R.color.ColorPrimary));

        }

    }

    @Override
    public int getItemCount() {
        return profileEntities.size();
    }
}
