package com.investallign.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.investallign.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
TextView tvChangePassword,tvEditProfile,tvAboutUs,tvTermsOfUse,tvPrivacyPolicy;
    private Toolbar toolbar;
    private TextView toolBarTtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbarManagement();


        tvChangePassword = (TextView)findViewById(R.id.activity_setting_txt_change_pwd);
        tvChangePassword.setOnClickListener(this);
        tvEditProfile= (TextView)findViewById(R.id.activity_setting_txt_edit_profile);
        tvEditProfile.setOnClickListener(this);

        tvAboutUs = (TextView)findViewById(R.id.activity_setting_txt_about_us);
        tvAboutUs.setOnClickListener(this);
        tvTermsOfUse= (TextView)findViewById(R.id.activity_setting_txt_tearm_of_use);
        tvTermsOfUse.setOnClickListener(this);
        tvPrivacyPolicy = (TextView)findViewById(R.id.activity_setting_txt_privacy_policy);
        tvPrivacyPolicy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_setting_txt_change_pwd:
                Intent i = new Intent(this,ChangePasswordActivity.class);
                startActivity(i);
                break;
            case R.id.activity_setting_txt_privacy_policy:
                Intent intentPrivacyPolicy = new Intent(this,PrivacyPolicyActivity.class);
                startActivity(intentPrivacyPolicy);
                break;
            case R.id.activity_setting_txt_tearm_of_use:
                Intent intentTearmOfUse = new Intent(this,TearmOfUseActivity.class);
                startActivity(intentTearmOfUse);
                break;
            case R.id.activity_setting_txt_about_us:
                Intent intentAboutUs = new Intent(this,AboutUsActivity.class);
                startActivity(intentAboutUs);
                break;
            case R.id.activity_setting_txt_edit_profile:
                Intent intentEditProfile = new Intent(this,EditProfileActivity.class);
                startActivity(intentEditProfile);
                break;
        }
    }
    private void toolbarManagement() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolBarTtitle = (TextView) toolbar.findViewById(R.id.tool_bar_title);
        toolBarTtitle.setText("Setting");
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
