package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.activity;

import android.Manifest;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.pager.viewpageradapter;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment.ThemeFiveFragment;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment.ThemeFourFragment;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment.ThemeOneFragment;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment.ThemeThreeFragment;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.themesfragment.ThemeTwoFragment;

public class MainActivityRecuirment extends AppCompatActivity {


   Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

   com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.pager.viewpageradapter viewpageradapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            ActivityCompat.requestPermissions(MainActivityRecuirment.this,new String[]
                            {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            tabLayout=(TabLayout)findViewById(R.id.tablayout);
            viewPager = (ViewPager)findViewById(R.id.viewpager);
            viewpageradapters = new viewpageradapter(getSupportFragmentManager());
            viewpageradapters.addfragment(new ThemeOneFragment() , "Theme One");
            viewpageradapters.addfragment(new ThemeTwoFragment() , "Theme Two");
            viewpageradapters.addfragment(new ThemeThreeFragment() , "Theme Three");
            viewpageradapters.addfragment(new ThemeFourFragment() , "Theme Four");
            viewpageradapters.addfragment(new ThemeFiveFragment() , "Theme Five");

            viewPager.setAdapter(viewpageradapters);
            tabLayout.setupWithViewPager(viewPager);
        } else{
            Toast.makeText(getApplicationContext(),"Low Version",Toast.LENGTH_LONG).show();
        }

    }
}
