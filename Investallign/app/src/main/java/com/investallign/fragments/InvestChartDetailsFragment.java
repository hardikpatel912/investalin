package com.investallign.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.investallign.R;
import com.investallign.activities.HomeActivity;

import java.util.ArrayList;

/**
 * Created by root on 2/12/16.
 */
public class InvestChartDetailsFragment extends Fragment implements View.OnClickListener {
    private View v;
    ImageView imgBack;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_piechart_second, container, false);


        HomeActivity.toolbar.setVisibility(View.GONE);
        PieChart pieChart = (PieChart) v.findViewById(R.id.chart_second);
        imgBack = (ImageView) v.findViewById(R.id.activity_piechart_img_back_second);
        imgBack.setOnClickListener(this);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));


        PieDataSet dataset = new PieDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Equilty");
        labels.add("MF");
        labels.add("DM");


        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(data);

        //pieChart.setDrawSliceText(false);
        pieChart.setDescription("");
        Legend l = pieChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);

        pieChart.saveToGallery("/sd/mychart.jpg", 85); // 85 is the quality of the image
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_piechart_img_back_second:
                Fragment newFragment = new InvestChartFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

                transaction.replace(R.id.actvity_piechar_ll_second, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
                break;
        }
    }


}
