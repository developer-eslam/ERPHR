package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.CheckNetwork;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && ((networkInfo.isConnected()))) {
            setContentView(R.layout.activity_main_warning);


            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(5000);
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();

        }else {
            startActivity(new Intent(MainActivity.this,CheckNetwork.class));
        }
    }
}
