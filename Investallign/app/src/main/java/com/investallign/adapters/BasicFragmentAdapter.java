package com.investallign.adapters;
 
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.entities.BasicEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BasicFragmentAdapter extends BaseAdapter {
    private Context activity;
    private LayoutInflater inflater;
    private List<BasicEntity> basicEntityList;

    public BasicFragmentAdapter(Context activity, List<BasicEntity> basicEntityList) {
        this.activity = activity;
        this.basicEntityList = basicEntityList;
    }

    @Override
    public int getCount() {
        return basicEntityList.size();
    }

    @Override
    public Object getItem(int location) {
        return basicEntityList.get(location);
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
            convertView = inflater.inflate(R.layout.list_row_basic_fragment, null);

        TextView videoNameTV = (TextView) convertView.findViewById(R.id.video_count);
        TextView viewTV = (TextView) convertView.findViewById(R.id.views_tv);
        ImageView videoView = (ImageView) convertView.findViewById(R.id.imageview);

        // getting movie data for the row
        BasicEntity m = basicEntityList.get(position);

        // thumbnail image
        // title
        videoNameTV.setText(m.getTitle());

        viewTV.setText(Html.fromHtml("<strong>"+m.getViews()+"</strong>"+"  Views"));
        // rating
//        viewTV.setText(m.getViews());


//        .getWindow().setFormat(PixelFormat.TRANSLUCENT);
//        Picasso.with(activity)
//                .load(m.getVideourl())
//                .into(videoView);


        return convertView;
    }

}