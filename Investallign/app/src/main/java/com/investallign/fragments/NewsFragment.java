package com.investallign.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.investallign.CustomViews.Ranger;
import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.adapters.NewsFragmentAdapter;
import com.investallign.entities.NewsEntity;
import com.investallign.interfaces.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment implements OnPageChangeListener {
    private List<NewsEntity> newsEntityList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsFragmentAdapter mAdapter;
    private View v;
    private NewsEntity newsEntity;
    private Ranger ranger;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_news, container, false);
        HomeActivity.toolbar.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_news_recycler_view);

        mAdapter = new NewsFragmentAdapter(newsEntityList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();

        ranger = (Ranger) v.findViewById(R.id.listener_ranger);
        ranger.setDayViewOnClickListener(new Ranger.DayViewOnClickListener() {
            @Override
            public void onDaySelected(int day) {
                Toast.makeText(getContext(), "Seleted Day: " + day, Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


    private void prepareMovieData() {

        for (int i = 0; i < 100; i++) {
            newsEntity = new NewsEntity("How Income Tax Department can monitor your money", "USA", "1 hour Ago","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard","http://images.indianexpress.com/2016/07/income-tax-759.jpg");
            newsEntityList.add(newsEntity);
        }
        mAdapter.notifyDataSetChanged();
    }



    @Override
    public void onPage() {
        HomeActivity.btnSetting.setVisibility(View.GONE);
        HomeActivity.toolbar.setVisibility(View.VISIBLE);
//        if (!flag) {
//            if (UtilityManager.isConnected(getContext())) {
//                isShowProgressBar(View.VISIBLE);
//                getFAQDetails();
//            } else {
//                flag = true;
//                showHideComponents(View.VISIBLE, getString(R.string.no_internet_connection));
//                isShowProgressBar(View.GONE);
//            }
//        }
    }

//
}