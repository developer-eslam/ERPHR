package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.firebasepackage;

import android.util.Log;

import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.SharedPrefManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Eslam on 4/7/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        storeToken(refreshedToken);
    }

    private void storeToken(String token){

        SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(token);
    }
}
