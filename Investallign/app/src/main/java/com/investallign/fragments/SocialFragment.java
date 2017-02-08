package com.investallign.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.adapters.ViewPagerAdapter;
import com.investallign.configuration.AppConstants;
import com.investallign.configuration.LoggerConstants;
import com.investallign.controls.SlidingTabLayout;
import com.investallign.interfaces.OnPageChangeListener;
import com.investallign.utils.Logger;
import com.investallign.utils.UtilityManager;

import java.util.ArrayList;
import java.util.List;


public class SocialFragment extends Fragment implements OnPageChangeListener {
    private List<Integer> drawbles = new ArrayList<>();
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence titles[] = {AppConstants.REVENUE_ROUTE, AppConstants.HI_ROUTE};
    private int noOfTabs = titles.length;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private TextView toolBarTtitle;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_social, container, false);

        HomeActivity.toolbar.setVisibility(View.VISIBLE);
        setFragments();
        pagerAndTabsManagement();

        return v;
    }


    private void setFragments() {

        fragments.add(new RevenueRouteFragment());
        fragments.add(new HiRouteFragment());
    }


    private void pagerAndTabsManagement() {
        drawbles.add(R.drawable.background_transparent);
        drawbles.add(R.drawable.background_transparent);
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), titles, noOfTabs, fragments, drawbles);
        pager = (ViewPager) v.findViewById(R.id.fragment_social_pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(noOfTabs);

        tabs = (SlidingTabLayout) v.findViewById(R.id.fragment_social_tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return UtilityManager.getColor(getContext(), R.color.orange);
            }
        });


        tabs.setViewPager(pager);


        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {

                Fragment selectedFragment = fragments.get(pos);
                if (selectedFragment instanceof RevenueRouteFragment) {
                    ((RevenueRouteFragment) selectedFragment).onPage();
                } else if (selectedFragment instanceof HiRouteFragment) {
                    ((HiRouteFragment) selectedFragment).onPage();
                }
                Logger.printLog(LoggerConstants.HOME_ACTIVITY, "onPageSelected");
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                Logger.printLog(LoggerConstants.HOME_ACTIVITY, "onPageScrolled");
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                Logger.printLog(LoggerConstants.HOME_ACTIVITY, "onPageScrollStateChanged");
            }
        });
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


}