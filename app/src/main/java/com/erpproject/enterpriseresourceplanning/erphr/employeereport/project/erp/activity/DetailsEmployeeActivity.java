package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.erpproject.enterpriseresourceplanning.erphr.R;


public class DetailsEmployeeActivity extends AppCompatActivity {


    TextView txtdisplayfirstname;
    TextView txtdisplaysceondname;
    TextView txtdisplaythirdname;
    TextView txtdisplayfourthname;
    TextView txtdisplayF_PK_SSN;



    TextView txtF_StreetAndBuilding;
    TextView txtF_DateOfStopingSSN;
    TextView txtF_Passport_Expired_Date;
    TextView txtF_Status;
    TextView txtF_Religion;
    TextView txtF_Nationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_employee_data);


        txtdisplayfirstname=(TextView)findViewById(R.id.txtdisplayfirstname);
        txtdisplaysceondname=(TextView)findViewById(R.id.txtdisplaysceondname);
        txtdisplaythirdname=(TextView)findViewById(R.id.txtdisplaythirdname);
        txtdisplayfourthname=(TextView)findViewById(R.id.txtdisplayfourthname);
        txtdisplayF_PK_SSN=(TextView)findViewById(R.id.txtdisplayF_PK_SSN);
        txtF_DateOfStopingSSN=(TextView)findViewById(R.id.txtdisplayF_DateOfStopingSSN);
        txtF_Nationality=(TextView)findViewById(R.id.txtdisplayF_Nationality);
        txtF_Passport_Expired_Date=(TextView)findViewById(R.id.txtdisplayF_Passport_Expired_Date);
        txtF_Religion=(TextView)findViewById(R.id.txtdisplayF_Religion);
        txtF_Status=(TextView)findViewById(R.id.txtdisplayF_Status);
        txtF_StreetAndBuilding=(TextView)findViewById(R.id.txtdisplayF_StreetAndBuilding);


        Intent intent = getIntent();
        if(intent!=null){
            String firstname= intent.getStringExtra("firstname");
            String secondname= intent.getStringExtra("secondname");
            String thirdname= intent.getStringExtra("thirdname");
            String fourthname= intent.getStringExtra("fourthname");
            String F_PK_SSN= intent.getStringExtra("F_PK_SSN");


            String F_DateOfStopingSSN= intent.getStringExtra("F_DateOfStopingSSN");
            String F_Nationality= intent.getStringExtra("F_Nationality");
            String F_Passport_Expired_Date= intent.getStringExtra("F_Passport_Expired_Date");
            String F_Religion= intent.getStringExtra("F_Religion");
            String F_Status= intent.getStringExtra("F_Status");
            String F_StreetAndBuilding= intent.getStringExtra("F_StreetAndBuilding");

            txtdisplayfirstname.setText(firstname);
            txtdisplaysceondname.setText(secondname);
            txtdisplaythirdname.setText(thirdname);
            txtdisplayfourthname.setText(fourthname);
            txtdisplayF_PK_SSN.setText(F_PK_SSN);



            txtF_DateOfStopingSSN.setText(F_DateOfStopingSSN);
            txtF_Nationality.setText(F_Nationality);
            txtF_Passport_Expired_Date.setText(F_Passport_Expired_Date);
            txtF_Religion.setText(F_Religion);
            txtF_Status.setText(F_Status);
            txtF_StreetAndBuilding.setText(F_StreetAndBuilding);


        }
    }
}
