package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.firebasepackage;

import android.content.Intent;
import android.util.Log;

import com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.activity.ShowDetialsNotification;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Eslam on 4/7/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                sendPushNotification(json);
            } catch (Exception e) {
            }
        }

    }

    private void sendPushNotification(JSONObject json) {
        Log.e(TAG, "Notification JSON " + json.toString());
        try {
            //getting the json data
            JSONObject data = json.getJSONObject("data");

            //parsing json data
            String nameemployee = data.getString("nameemployee");
            String causeproblem = data.getString("causeproblem");

            NotificationManagers notificationManagers = new NotificationManagers(getApplicationContext());


           Intent intent = new Intent(getApplicationContext(),ShowDetialsNotification.class);

            intent.putExtra("causeproblem",causeproblem);
            intent.putExtra("nameemployee",nameemployee);

            notificationManagers.showSmallNotification(nameemployee, causeproblem, intent);

        } catch (JSONException e) {
        } catch (Exception e) {
        }
    }
}
