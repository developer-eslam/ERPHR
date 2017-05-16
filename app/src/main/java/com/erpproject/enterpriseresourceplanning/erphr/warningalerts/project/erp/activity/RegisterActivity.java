package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;

    Button btnregister;
    Button btnreporting;
    EditText txtname;

    ProgressDialog progressDialog;
    private static final String URL_REGISTER = "http://warningalerts.comeze.com/RegisterDevice.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setSupportActionBar(toolbar);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.logo);
        txtname=(EditText)findViewById(R.id.txtinputlauoutname);
        btnregister=(Button)findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(txtname.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Must Be Insert Name", Toast.LENGTH_SHORT).show();
                }else {
                    sendtokentoserver();
                }
            }
        });
        btnreporting=(Button)findViewById(R.id.btninsertdata);

        btnreporting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,DetailsActivity.class));
            }
        });

    }

    private  void sendtokentoserver(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering Device...");
        progressDialog.show();

        final  String token = SharedPrefManager.getmInstance(this).getDeviceToken();
        final String  name = txtname.getText().toString();
        if(token==null){
            progressDialog.dismiss();
            Toast.makeText(this, "Token not generated", Toast.LENGTH_LONG).show();
            return;
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(RegisterActivity.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("token", token);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
    }

