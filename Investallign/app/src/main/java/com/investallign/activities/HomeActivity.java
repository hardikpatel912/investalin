package com.investallign.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.adapters.ViewPagerAdapter;
import com.investallign.configuration.AppConstants;
import com.investallign.configuration.LoggerConstants;
import com.investallign.controls.SlidingTabLayout;
import com.investallign.fragments.HomeFragment;
import com.investallign.fragments.NewsFragment;
import com.investallign.fragments.ProfileFragment;
import com.investallign.fragments.SocialFragment;
import com.investallign.fragments.TutorialFragment;
import com.investallign.utils.Logger;
import com.investallign.utils.UtilityManager;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    public static Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence titles[] = {AppConstants.SOCIAL, AppConstants.NEWS, AppConstants.HOME, AppConstants.TUTORIAL, AppConstants.PROFILE};
    public static List<Integer> drawbles = new ArrayList<>();
    private int noOfTabs = titles.length;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private TextView toolBarTtitle;
    public static ImageView btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setFragments();
        toolbarManagement();
        pagerAndTabsManagement();


    }

    private void setFragments() {
        fragments.add(new SocialFragment());
        fragments.add(new NewsFragment());
        fragments.add(new HomeFragment());
        fragments.add(new TutorialFragment());
        fragments.add(new ProfileFragment());
    }


    private void pagerAndTabsManagement() {
        drawbles.add(R.drawable.selector_social_tab);
        drawbles.add(R.drawable.selector_news_tab);
        drawbles.add(R.drawable.selector_home_tab);
        drawbles.add(R.drawable.selector_tutorial_tab);
        drawbles.add(R.drawable.selector_profile_tab);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles, noOfTabs, fragments, drawbles);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(noOfTabs);
        pager.setCurrentItem(2);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return UtilityManager.getColor(HomeActivity.this, R.color.tabsScrollColor);
            }
        });
        tabs.setFromActivity(true);

        tabs.setViewPager(pager);

        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {

                Fragment selectedFragment = fragments.get(pos);
                if (selectedFragment instanceof HomeFragment) {
                    ((HomeFragment) selectedFragment).onPage();
                } else if (selectedFragment instanceof TutorialFragment) {
                    ((TutorialFragment) selectedFragment).onPage();
                } else if (selectedFragment instanceof ProfileFragment) {
                    ((ProfileFragment) selectedFragment).onPage();
                } else if (selectedFragment instanceof NewsFragment) {
                    ((NewsFragment) selectedFragment).onPage();
                } else if (selectedFragment instanceof SocialFragment) {
                    ((SocialFragment) selectedFragment).onPage();
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

    private void toolbarManagement() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolBarTtitle = (TextView) toolbar.findViewById(R.id.tool_bar_title);
        toolBarTtitle.setPadding(0,0,0,0);
        btnSetting = (ImageView) toolbar.findViewById(R.id.tool_bar_setting_logo);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // getSupportActionBar().setHomeAsUpIndicator(R.drawable.app_icon);
            // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

