package com.erpproject.enterpriseresourceplanning.erphr.warningalerts.project.erp.firebasepackage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.erpproject.enterpriseresourceplanning.erphr.R;


/**
 * Created by Eslam on 4/10/2017.
 */

public class NotificationManagers {
    private static final int ID_NOTIFICATION = 235;
    private Context ctx;
    public NotificationManagers(Context context){
        ctx=context;
    }
    public void showSmallNotification(String nameemployee, String causeproblem, Intent intent) {
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        ctx,
                        ID_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ctx);
        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.ic_launcher).setTicker(nameemployee).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(nameemployee)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(causeproblem)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_NOTIFICATION, notification);
    }

}
