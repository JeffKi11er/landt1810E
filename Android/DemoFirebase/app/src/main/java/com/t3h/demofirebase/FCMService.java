package com.t3h.demofirebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FCMService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Token");
        reference.child("BacNV")
                .setValue(s);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("FCMService", "FCMService",
                            NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        String title = remoteMessage.getData().get("title");
        String message = remoteMessage.getData().get("message");

//        builder.setContentTitle("From foreground: "+remoteMessage.getNotification().getTitle());
//        builder.setContentText(remoteMessage.getNotification().getBody());
        builder.setContentTitle("From foreground: "+title);
        builder.setContentText(message);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("FCMService");
        }
        manager.notify(1217212, builder.build());
    }
}
