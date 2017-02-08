package com.investallign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.investallign.R;
import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    private String title;
    private String country;
    private String duration;
    private String description;
    private String url;
    private Toolbar toolbar;
    private TextView toolBarTtitle;
    TextView txtTitle, txtCountry, txtDuration, txtDescription;
    ImageView ivNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        toolbarManagement();
        txtTitle = (TextView)findViewById(R.id.news_details_activity_tv_title);
        txtCountry = (TextView)findViewById(R.id.news_details_activity_tv_country);
        txtDuration = (TextView)findViewById(R.id.news_details_activity_tv_duration);
        txtDescription = (TextView)findViewById(R.id.news_details_activity_tv_description);
        ivNews = (ImageView) findViewById(R.id.news_details_activity_iv_news);

        Intent intent = getIntent();

        title = intent.getStringExtra("TITLE");
        country = intent.getStringExtra("COUNTRY");
        duration = intent.getStringExtra("DURATION");
        description = intent.getStringExtra("DESCRIPTION");
        url = intent.getStringExtra("URL");

        txtTitle.setText(title);
        txtCountry.setText(country);
        txtDuration.setText(duration);
        txtDescription.setText(description);

        Picasso.with(this)
                .load(url)
                .into(ivNews);
    }
    private void toolbarManagement() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolBarTtitle = (TextView) toolbar.findViewById(R.id.tool_bar_title);
        toolBarTtitle.setText("News Detail");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // getSupportActionBar().setHomeAsUpIndicator(R.drawable.app_icon);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
