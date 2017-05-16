package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.erpproject.enterpriseresourceplanning.erphr.R;


public class ShowDetialsNotification extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detials_notification);
        setSupportActionBar(toolbar);
        toolbar=(Toolbar)findViewById(R.id.showtoolbaractivity);
        toolbar.setLogo(R.drawable.logo);
        TextView txtnameemployee = (TextView)findViewById(R.id.txtdisplaynameemployee);
        TextView txtcauseproblem = (TextView)findViewById(R.id.txtdisplaycauseproblem);

        Intent intent = getIntent();
        String causeproblem = intent.getExtras().getString("causeproblem");
        String nameemployee = intent.getExtras().getString("nameemployee");

        txtnameemployee.setText(nameemployee);
        txtcauseproblem.setText(causeproblem);
    }
}
