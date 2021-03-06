package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.internet;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.MainActivityReports;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.internet.CheckNetwork;

public class CheckNetwork  extends Activity {

    Button button;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checknetwokreport);
        button=(Button)findViewById(R.id.button);
        Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        // set animation listener
        button.startAnimation(animFadein);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();

                if(networkInfo!=null&&networkInfo.isConnected())
                {
                    Toast.makeText(CheckNetwork.this, "Network Available", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CheckNetwork.this,MainActivityReports.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(new Intent(intent));
                }
                else
                {
                    Toast.makeText(CheckNetwork.this, "Network Not Available", Toast.LENGTH_LONG).show();

                }

            }
        });
    }


}