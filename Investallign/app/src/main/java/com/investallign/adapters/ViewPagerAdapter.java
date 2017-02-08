package com.investallign.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[];
    int NumbOfTabs;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<Integer> drawbles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, List<Fragment> fragments, List<Integer> drawbles) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.fragments = fragments;
        this.drawbles = drawbles;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return fragments.get(0);
        } else if (position == 1) {
            return fragments.get(1);
        } else if (position == 2) {
            return fragments.get(2);
        } else if (position == 3) {
            return fragments.get(3);
        } else if (position == 4) {
            return fragments.get(4);
        }

        return null;
    }


    @Override
    public String getPageTitle(int position) {
        return Titles[position] + ";" + drawbles.get(position);
    }


    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}