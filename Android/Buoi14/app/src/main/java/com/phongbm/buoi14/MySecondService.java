package com.phongbm.buoi14;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MySecondService extends Service {
    private final String TAG = "MySecondService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        pushNotification();
    }

    private void pushNotification() {
        String CHANNEL_ID = "CHANNEL_ID";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_ID,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
        Intent intent = new Intent(this, getClass());
        intent.putExtra("EXTRA_NEED_STOP", true);
        PendingIntent pending = PendingIntent.getService(this,
                0, intent, 0);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("Push notification");
        builder.setContentTitle("Keep service running");
        builder.setContentText("Using foreground service");

        builder.setContentIntent(pending);

        startForeground(1213232, builder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null){
            boolean needStop = intent.
                    getBooleanExtra("EXTRA_NEED_STOP", false);
            if (needStop){
                stopSelf();
                return START_NOT_STICKY;
            }
        }
        Log.e(TAG, "onStartCommand");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                for (int j = 0; ; j++) {
//                    Log.e(TAG, j + "");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        stopForeground(true);
    }
}
