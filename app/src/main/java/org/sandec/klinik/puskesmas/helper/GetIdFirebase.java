package org.sandec.klinik.puskesmas.helper;

import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.sandec.klinik.puskesmas.activities.Konstanta;

/**
 * Created by wakhyudi on 18/12/17.
 */

public class GetIdFirebase extends FirebaseInstanceIdService {

    public  String idFirebase;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        idFirebase = FirebaseInstanceId.getInstance().getToken();

        SharedPreferences sp = getSharedPreferences(Konstanta.FIREBASE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Konstanta.TOKEN_FIREBASE,idFirebase);
        editor.commit();

        //membuat state apakah id device sudah dikirim
        SharedPreferences spIdKirim = getSharedPreferences("token",MODE_PRIVATE);
        SharedPreferences.Editor editorId = spIdKirim.edit();
        editorId.putBoolean("id",false);
        editorId.commit();



    }
}
