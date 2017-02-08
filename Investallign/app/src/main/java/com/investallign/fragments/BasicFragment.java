package com.investallign.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.investallign.R;
import com.investallign.adapters.BasicFragmentAdapter;
import com.investallign.entities.BasicEntity;
import com.investallign.interfaces.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;


public class BasicFragment extends Fragment implements OnPageChangeListener {

    private static final String TAG = BasicFragment.class.getSimpleName();

    // Movies json url
    private ProgressDialog pDialog;
    private List<BasicEntity> basicEntityArrayList = new ArrayList<BasicEntity>();
    private ListView listView;
    private BasicFragmentAdapter adapter;
    private View v;
    private BasicEntity basicEntity;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_basic, container, false);

        pDialog = new ProgressDialog(getContext());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        listView = (ListView) v.findViewById(R.id.fragment_basic_route_listview);
        // changing action bar color

        for (int i = 1; i <= 10; i++) {
            basicEntity = new BasicEntity();

            basicEntity.setTitle("Tutorial Video " +i);
            basicEntity.setViews("1250");
            basicEntity.setVideourl("http://img06.deviantart.net/5313/i/2011/307/8/9/follow_the_river_7th_fantasy__big_size_by_burtn-d4ex6r5.jpg");
            basicEntityArrayList.add(basicEntity);
        }

        adapter = new BasicFragmentAdapter(getContext(), basicEntityArrayList);
        listView.setAdapter(adapter);
        hidePDialog();
        return v;
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public void onPage() {

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