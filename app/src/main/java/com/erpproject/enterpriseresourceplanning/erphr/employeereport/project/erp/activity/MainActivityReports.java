package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.fragment.FragmentReport;

import java.util.ArrayList;
import java.util.List;

import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.internet.CheckNetwork;

public class MainActivityReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo!=null&&((networkInfo.isConnected()))) {
            setContentView(R.layout.activity_main_report);
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(new FragmentReport());


//            List<String> titles = new ArrayList<>(2);
//            titles.add("1");
//            titles.add("2");
//
//            assert pager != null;
//            pager.setAdapter(new PagerAdapter(getSupportFragmentManager(), fragments, titles));
        }else {
            Intent intent = new Intent(MainActivityReports.this, CheckNetwork.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }



}
