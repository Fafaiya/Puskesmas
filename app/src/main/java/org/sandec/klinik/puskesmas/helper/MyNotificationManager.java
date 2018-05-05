package org.sandec.klinik.puskesmas.helper;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.activities.Konstanta;
import org.sandec.klinik.puskesmas.activities.PendaftaranBerhasilActivity;

/**
 * Created by wakhyudi on 15/04/18.
 */

public class MyNotificationManager {

    private Context context;
    private static MyNotificationManager mnmInstance;

    public MyNotificationManager(Context context) {
        this.context = context;
    }

    public static synchronized MyNotificationManager getMnmInstance(Context context1){
        if(mnmInstance==null){
            mnmInstance = new MyNotificationManager(context1);
        }
        return mnmInstance;
    }

    public void displayNotification(String title, String body){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, Konstanta.Channel_ID)
                                        .setSmallIcon(R.drawable.logo_puskesma)
                                        .setContentTitle(title)
                                        .setContentText(body);

        //intent di dalam notif
        Intent i = new Intent(context, PendaftaranBerhasilActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                0,
                i,
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManager mNotifMygr = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(mNotifMygr!=null){
            mNotifMygr.notify(1,builder.build());
        }
    }

}
