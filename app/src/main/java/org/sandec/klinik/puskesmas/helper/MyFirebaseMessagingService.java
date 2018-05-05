package org.sandec.klinik.puskesmas.helper;

import android.app.NotificationManager;
import android.app.PendingIntent;
//import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.activities.Konstanta;
import org.sandec.klinik.puskesmas.activities.MainActivity;
import org.sandec.klinik.puskesmas.activities.PendaftaranBerhasilActivity;
import org.sandec.klinik.puskesmas.activities.SplashActivity;

/**
 * Created by wakhyudi on 09/04/18.
 */

@SuppressWarnings("ALL")
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);

        sendMyNotif(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"));

//        MyNotificationManager myNotificationManager = new MyNotificationManager(this);
//        String title = remoteMessage.getNotification().getTitle();
//        String body = remoteMessage.getNotification().getBody();
//        myNotificationManager.displayNotification(title,body);
//        if (remoteMessage.getData().size()>0){
//            String message = remoteMessage.getData().get("body");
//            String response = remoteMessage.getData().get("title");
//
////            kemudian mengirim data ke activity yang dituju
//            Intent i = new Intent("com.sandec.fcm");
//            i.putExtra("message",message);
//            i.putExtra("response",response);
//            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
//            localBroadcastManager.sendBroadcast(i);
//
//
//        }

//        Intent i = new Intent("com.sandec.fcm");
//        String title = remoteMessage.getNotification().getTitle();
//        String body = remoteMessage.getNotification().getBody();
//
//        i.putExtra("message",body);
//        i.putExtra("response",title);
//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        localBroadcastManager.sendBroadcast(i);

    }

    private void sendMyNotif(String title, String body) {

        int requestID = (int) System.currentTimeMillis();
//        Intent intent = new Intent(getApplicationContext(), PendaftaranBerhasilActivity.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
//        stackBuilder.addParentStack(MainActivity.class);
//        stackBuilder.addNextIntent(intent);
//        PendingIntent pendingIntent = stackBuilder.getPendingIntent(requestID, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent i = new Intent(getApplicationContext(), PendaftaranBerhasilActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,requestID,i,PendingIntent.FLAG_UPDATE_CURRENT);

        //ini untuk suara
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        //create notif
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                                        .setSmallIcon(R.mipmap.ic_logo_puskesmas)
                                        .setContentTitle(title)
                                        .setContentText(body)
                                        .setSound(soundUri)
                                        .setAutoCancel(true)
                                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(Konstanta.NOTIFICATION_ID,notificationBuilder.build());
    }
}
