package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.MyVolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    private Button buttonSendPush;
    private Spinner spinner;
    private ProgressDialog progressDialog;

    private EditText txtnameemployee, txtcauseproblem;

    private List<String> employees;
    public static final String URL_SEND_PUSH = "http://warningalerts.comeze.com/sendnotification.php";

    private static final String   URL_FETCH_EMPLOYEES = "http://warningalerts.comeze.com/GetRegisteredDevices.php";

    JSONObject obj ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setSupportActionBar(toolbar);
        toolbar=(Toolbar)findViewById(R.id.toolbardetails);
        toolbar.setLogo(R.drawable.logo);


        spinner = (Spinner) findViewById(R.id.spinnerDevices);
        buttonSendPush = (Button) findViewById(R.id.btnsendnotification);

        txtnameemployee = (EditText) findViewById(R.id.txtnameemployee);
        txtcauseproblem = (EditText) findViewById(R.id.txtcauseproblem);
        employees = new ArrayList<>();


        buttonSendPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nameemployee = txtnameemployee.getText().toString();
                final String causeproblem = txtcauseproblem.getText().toString();
                final String name = spinner.getSelectedItem().toString();

                if(TextUtils.isEmpty(nameemployee)){
                    Toast.makeText(getApplicationContext(),"Must Insert Name Employee",Toast.LENGTH_LONG).show();

                }else if(TextUtils.isEmpty(causeproblem)){
                    Toast.makeText(getApplicationContext(),"Must Insert Cause Problem",Toast.LENGTH_LONG).show();
                }else {
                    progressDialog.setMessage("Sending Push");
                    progressDialog.show();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SEND_PUSH,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    progressDialog.dismiss();


                                    Toast.makeText(DetailsActivity.this, response, Toast.LENGTH_LONG).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("nameemployee", nameemployee);
                            params.put("causeproblem", causeproblem);
                            params.put("name", name);
                            return params;


                        }
                    };

                    MyVolley.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }
            }
        });
        loadRegisteredEmployees();

    }

    private void loadRegisteredEmployees() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Devices...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_FETCH_EMPLOYEES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                JSONArray jsonDevices = obj.getJSONArray("employee");

                                for (int i = 0; i < jsonDevices.length(); i++) {
                                    JSONObject d = jsonDevices.getJSONObject(i);
                                    employees.add(d.getString("name"));
                                }

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                                        DetailsActivity.this,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        employees);

                                spinner.setAdapter(arrayAdapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

        };
        MyVolley.getInstance(this).addToRequestQueue(stringRequest);
    }

}
