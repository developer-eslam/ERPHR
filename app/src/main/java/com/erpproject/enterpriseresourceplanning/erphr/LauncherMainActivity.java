package com.erpproject.enterpriseresourceplanning.erphr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.SplashActivity;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject.ActivityReportDisplay;

public class LauncherMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_main);


        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(LauncherMainActivity.this, MainActivityApp.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
