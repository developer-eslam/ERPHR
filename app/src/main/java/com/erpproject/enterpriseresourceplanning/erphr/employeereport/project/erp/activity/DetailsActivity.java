package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity;

import android.content.Intent;
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
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.adapter.DetailsEmployeeData;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.adapter.RecyclerViewApdaterEmployeeReports;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject.NetworkController;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.fragment.FragmentReport;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.model.employees;

public class DetailsActivity extends AppCompatActivity {


    List<employees> employeesList=new ArrayList<>();
    RequestQueue requestQueue;
    NetworkController networkController;
    RecyclerView recyclerView;
    DetailsEmployeeData detailsEmployeeData;

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        requestQueue = Volley.newRequestQueue(getApplicationContext());


        recyclerView=(RecyclerView)findViewById(R.id.detailsrecyclereview);

        detailsEmployeeData=new DetailsEmployeeData(getApplicationContext(),employeesList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerView.setAdapter(detailsEmployeeData);

        requestQueue = (networkController.getNetworkController(getApplicationContext()).getmRequestQueue());

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("name");
        String password = bundle.getString("password");
        String url = "http://192.168.177.1/ERP_MVC_1/?view=hr_admin&page=retreive_all_hr_acount&api=ALLAccounts";



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
                        employees employees = new employees(F_FirstName,F_SecondName,F_ThirdName,F_FourthName,F_PK_SSN);


                        employeesList.add(employees);





                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }finally {
                    detailsEmployeeData.notifyItemChanged(i);
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

