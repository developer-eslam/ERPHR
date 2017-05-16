package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.adapter.RecyclerViewApdaterEmployeeReports;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.model.employees;

public class ActivityReportDisplay extends AppCompatActivity {



    List<employees> employeesList=new ArrayList<>();
    RequestQueue requestQueue;
    NetworkController networkController;
    RecyclerView recyclerView;
    RecyclerViewApdaterEmployeeReports recyclerViewApdaterEmployeeReports;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_display);



        requestQueue = Volley.newRequestQueue(getApplicationContext());


        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        recyclerViewApdaterEmployeeReports=new RecyclerViewApdaterEmployeeReports(getApplicationContext().getApplicationContext(),employeesList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(recyclerViewApdaterEmployeeReports);

        requestQueue = (networkController.getNetworkController(getApplicationContext().getApplicationContext()).getmRequestQueue());


        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("F_AccountName");
        String password = bundle.getString("F_Password");
        String url = "http://192.168.177.1/ERP_MVC_1/?view=hr_admin&page=retreive_all_employees_api&api=allEmployees&username="+username+"&password="+password;

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("AllEmployees");
                    for( i = 0 ; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        final String F_FirstName = jsonObject.getString("F_FirstName");
                        final String F_SecondName = jsonObject.getString("F_SecondName");
                        final String F_ThirdName = jsonObject.getString("F_ThirdName");
                        final String F_FourthName = jsonObject.getString("F_FourthName");
                        final String F_PK_SSN     = jsonObject.getString("F_PK_SSN");
                        final String F_StreetAndBuilding = jsonObject.getString("F_StreetAndBuilding");
                        final String F_Religion = jsonObject.getString("F_Religion");
                        final String F_Nationality = jsonObject.getString("F_Nationality");
                        final String F_Status = jsonObject.getString("F_Status");
                        final String F_Passport_Expired_Date = jsonObject.getString("F_Passport_Expired_Date");
                        final String F_DateOfStopingSSN = jsonObject.getString("F_DateOfStopingSSN");

                        employees employees = new employees(F_FirstName,F_SecondName,
                                F_ThirdName,F_FourthName,F_PK_SSN,F_StreetAndBuilding
                                ,F_DateOfStopingSSN,F_Passport_Expired_Date,
                                F_Status,F_Religion ,F_Nationality);


                        employeesList.add(employees);





                    }

                    recyclerViewApdaterEmployeeReports.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }finally {
                    recyclerViewApdaterEmployeeReports.notifyItemChanged(i);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);

    }
}
