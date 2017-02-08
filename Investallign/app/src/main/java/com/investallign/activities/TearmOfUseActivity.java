package com.investallign.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.investallign.R;
public class TearmOfUseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView toolBarTtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tearm_of_use);
        toolbarManagement();
    }
    private void toolbarManagement() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolBarTtitle = (TextView) toolbar.findViewById(R.id.tool_bar_title);
        toolBarTtitle.setText("Tearm Of Use");

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