package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Eslam on 4/10/2017.
 */

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "FCMSharedPref";
    private static final String TAG_TOKEN = "tagtoken";


    private static SharedPrefManager mInstance;
    private static Context mctx;

    private SharedPrefManager(Context context){
        mctx=context;
    }
    public static synchronized SharedPrefManager getmInstance(Context context){
        if(mInstance==null){
            mInstance = new SharedPrefManager(context);
        }
        return  mInstance;
    }

    public boolean saveDeviceToken(String token){
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN,token);
        editor.apply();
        return  true;
    }

    public  String getDeviceToken(){
        SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(TAG_TOKEN, null);
    }

}
