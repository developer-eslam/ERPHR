package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.LoginActivity;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject.ActivityReportDisplay;

import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.internet.CheckNetwork;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && ((networkInfo.isConnected()))) {

            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(5000);
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

        }else {
            startActivity(new Intent(SplashActivity.this, CheckNetwork.class));
        }
    }
}
