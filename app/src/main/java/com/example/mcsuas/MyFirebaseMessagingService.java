package com.example.mcsuas;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static ArrayList<ObjectNotif> store = new ArrayList<>();
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        store.add(new ObjectNotif(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody()));

        Log.d("testing",remoteMessage.getFrom());
        Log.d("testing",remoteMessage.getNotification().getBody());
//        Log.d("testing", store);
    }
    private void sendNotification(String title, String body){
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String cID = "id", cName = "name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, cID)
                .setSmallIcon(R.drawable.baseline_notifications_none_24)
                .setContentTitle(title)
                .setContentText(body);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(cID, cName,importance);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(1, builder.build());
    }
}
