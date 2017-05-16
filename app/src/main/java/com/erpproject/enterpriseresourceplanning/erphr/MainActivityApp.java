package com.erpproject.enterpriseresourceplanning.erphr;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.MainActivityReports;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.SplashActivity;
import com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.activity.MainActivityRecuirment;
import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity.MainActivity;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;


public class MainActivityApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);


        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#ffffff"),R.drawable.add,R.drawable.cancel)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.report)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.ic_launcher)
                .addSubMenu(Color.parseColor("#ffffff"),R.drawable.employee)

                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {


                        switch (i){
                            case 0:

                                startActivity(new Intent(MainActivityApp.this,SplashActivity.class));
                                break;

                            case 2:
                                startActivity(new Intent(MainActivityApp.this,MainActivity.class));

                                //startActivity(new Intent(MainActivityApp.this,MainActivityReports.class));
                                //  startActivity(new Intent(MainActivityApp.this,SplashActivity.class));

                                break;
                            case 1:
                                startActivity(new Intent(MainActivityApp.this,MainActivityRecuirment.class));
                                break;


                        }
                    }
                });


    }
}
