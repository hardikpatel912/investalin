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

import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.adapters.HomeFragmentAdapter;
import com.investallign.entities.AccountBalanceEntity;
import com.investallign.interfaces.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnPageChangeListener {

    private List<AccountBalanceEntity> accountBalanceEntityList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HomeFragmentAdapter mAdapter;
    private View v;
    private AccountBalanceEntity accountBalanceEntity;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        HomeActivity.toolbar.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_home_recycler_view);

        mAdapter = new HomeFragmentAdapter(accountBalanceEntityList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return v;
    }

    private void prepareMovieData() {

        for (int i = 0; i < 10; i++) {
            accountBalanceEntity = new AccountBalanceEntity("1,500", "1,375", "125","Monday, 10 Oct, 2016","orange");
            if(i==2)
            {
                accountBalanceEntity = new AccountBalanceEntity("1,500", "1,375", "125","Monday, 10 Oct, 2016","green");
            }
            if(i==12)
            {
                accountBalanceEntity = new AccountBalanceEntity("1,500", "1,375", "125","Monday, 10 Oct, 2016","green");
            }
            accountBalanceEntityList.add(accountBalanceEntity);
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