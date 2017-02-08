package com.investallign.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.activities.SettingActivity;
import com.investallign.adapters.ProfileFragmentAdapter;
import com.investallign.entities.ProfileEntity;
import com.investallign.interfaces.OnPageChangeListener;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment implements OnPageChangeListener {
    private List<ProfileEntity> profileEntityList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProfileFragmentAdapter mAdapter;
    private View v;
    private ProfileEntity profileEntity;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile, container, false);
        HomeActivity.toolbar.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_profile_recycler_view);

        mAdapter = new ProfileFragmentAdapter(profileEntityList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareProfileData();
        return v;
    }

    private void prepareProfileData() {

        for (int i = 1; i < 12; i++) {

            if (i == 1 || i == 4 || i == 7 || i == 10) {
                profileEntity = new ProfileEntity("jan 2016", "18,500", "green");
            }
            if (i == 2 || i == 5 || i == 8 || i == 11) {
                profileEntity = new ProfileEntity("jan 2016", "18,500", "orange");
            }
            if (i == 3 || i == 6 || i == 9 || i == 12) {
                profileEntity = new ProfileEntity("jan 2016", "18,500", "blue");
            }
            profileEntityList.add(profileEntity);
        }
        mAdapter.notifyDataSetChanged();


    }


    @Override
    public void onPage() {
        HomeActivity.toolbar.setVisibility(View.VISIBLE);
        HomeActivity.btnSetting.setVisibility(View.VISIBLE);
        HomeActivity.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
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