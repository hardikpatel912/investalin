package com.investallign.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.investallign.R;
import com.investallign.activities.HomeActivity;

import java.util.ArrayList;

/**
 * Created by root on 2/12/16.
 */
public class InvestChartFragment extends Fragment implements View.OnClickListener {
    private View v;
    ImageView imgBack;
    Button button;
    LinearLayout pieCharLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_piechart_first, container, false);

        button = (Button) v.findViewById(R.id.invest_automatically);

        HomeActivity.toolbar.setVisibility(View.GONE);
        PieChart pieChart = (PieChart) v.findViewById(R.id.chart);
        pieCharLayout = (LinearLayout) v.findViewById(R.id.chart_layout);
        imgBack = (ImageView) v.findViewById(R.id.activity_piechart_img_back);
        imgBack.setOnClickListener(this);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(10f, 4));


        PieDataSet dataset = new PieDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Equilty");
        labels.add("Commadity");
        labels.add("Debt Market");
        labels.add("Fixed Income");
        labels.add("Others");


        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(data);

        //pieChart.setDrawSliceText(false);
        pieChart.setDescription("");
        Legend l = pieChart.getLegend();
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);

        pieChart.saveToGallery("/sd/mychart.jpg", 85);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                Fragment newFragment1 = new InvestChartDetailsFragment();
                FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
//                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

                transaction1.replace(R.id.actvity_piechar_ll, newFragment1);
                transaction1.addToBackStack(null);


                transaction1.commit();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // 85 is the quality of the image

//        pieChart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment newFragment1 = new InvestChartDetailsFragment();
//                FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
////                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();
//
//                transaction1.replace(R.id.actvity_piechar_ll, newFragment1);
//                transaction1.addToBackStack(null);
//
//
//                transaction1.commit();
//            }
//        });
        return v;
    }

    public void onPieCharClick()
    {
        Fragment newFragment1 = new InvestChartDetailsFragment();
        FragmentTransaction transaction1 = getChildFragmentManager().beginTransaction();
//                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

        transaction1.replace(R.id.actvity_piechar_ll, newFragment1);
        transaction1.addToBackStack(null);


        transaction1.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_piechart_img_back:
                Fragment newFragment = new HomeFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

                transaction.replace(R.id.actvity_piechar_ll, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
                break;
        }
    }


}
