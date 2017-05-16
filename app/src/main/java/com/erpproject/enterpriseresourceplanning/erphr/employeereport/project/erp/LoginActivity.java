package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.erpproject.enterpriseresourceplanning.erphr.R;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.activity.DetailsActivity;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject.ActivityReportDisplay;
import com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.com.example.erproject.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    Button btnlogin;
    EditText txtusername;
    EditText txtuserpassword;

    String username,password;


    String url_login = "http://localhost/ERP_MVC_1/?view=hr_admin&page=retreive_all_hr_acount&api=ALLAccounts";

    AlertDialog.Builder aBuilder;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        aBuilder = new AlertDialog.Builder(this);

        btnlogin=(Button)findViewById(R.id.btnlogin);
        txtusername=(EditText)findViewById(R.id.txtusername);
        txtuserpassword=(EditText)findViewById(R.id.txtpassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = txtusername.getText().toString();

                password = txtuserpassword.getText().toString();

                if(TextUtils.isEmpty(username)&&TextUtils.isEmpty(password)){
                    aBuilder.setMessage("Something Wrong....");
                    displayalert("input_error");
                }


                else{

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url_login, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {

                                JSONArray jsonArray = new JSONArray("ALLAccounts");

                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject ALLAccountsarray = jsonArray.getJSONObject(i);

                                    String F_AccountName = ALLAccountsarray.getString("F_AccountName");
                                    String F_Password = ALLAccountsarray.getString("F_Password");

                                        Intent intent = new Intent(LoginActivity.this,ActivityReportDisplay.class);
                                        intent.putExtra("F_AccountName",F_AccountName);
                                        intent.putExtra("F_Password",F_Password);

                                        startActivity(intent);
                                }






                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(),error.getMessage().toString(),Toast.LENGTH_LONG).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String,String>params = new HashMap<String, String>();
                            params.put("F_AccountName",username);
                            params.put("F_Password",password);

                            return params;
                        }
                    };

                    MySingleton.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);
                }



            }
        });
    }

    public void displayalert(final String code){
        aBuilder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(code.equals("input_error")){
                    txtuserpassword.setText("");
                }else if(code.equals("reg_success")){
                    finish();
                }else if(code.equals("reg_failed")){
                    txtusername.setText("");
                    txtuserpassword.setText("");

                    txtusername.setText("");

                }
            }
        });

        AlertDialog alertDialog = aBuilder.create();
        alertDialog.show();
    }

}
