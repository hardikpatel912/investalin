package com.investallign.adapters;
 
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.investallign.CustomViews.RoundedImageView;
import com.investallign.R;
import com.investallign.entities.RevenueFragmentEntity;

import java.util.List;

public class RevenueFragmentAdapter extends BaseAdapter {
    private Context activity;
    private LayoutInflater inflater;
    private List<RevenueFragmentEntity> revenueItemList;

    public RevenueFragmentAdapter(Context activity, List<RevenueFragmentEntity> revenueItemList) {
        this.activity = activity;
        this.revenueItemList = revenueItemList;
    }

    @Override
    public int getCount() {
        return revenueItemList.size();
    }

    @Override
    public Object getItem(int location) {
        return revenueItemList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_revenue_fragment, null);

        RoundedImageView thumbNail = (RoundedImageView) convertView
                .findViewById(R.id.fragment_revenue_route_iv);

        ImageView thumbNailRight = (ImageView) convertView
                .findViewById(R.id.fragment_revenue_route_iv_right);

        TextView title = (TextView) convertView.findViewById(R.id.fragment_revenue_route_tv_title);
        TextView subTitle = (TextView) convertView.findViewById(R.id.fragment_revenue_route_tv_sub_title);

        // getting movie data for the row
        RevenueFragmentEntity m = revenueItemList.get(position);

        // thumbnail image
        thumbNail.setImageResource(Integer.parseInt(m.getLeftSideImage()));
        thumbNailRight.setImageResource(Integer.parseInt(m.getRightSideImage()));

        // title
        title.setText(m.getTitle());

        // rating
        subTitle.setText("Sub Title : " + String.valueOf(m.getSubTitle()));

        // genre
        return convertView;
    }

}