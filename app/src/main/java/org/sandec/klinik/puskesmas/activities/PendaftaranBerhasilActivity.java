package org.sandec.klinik.puskesmas.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.Antrian;
import org.sandec.klinik.puskesmas.model.DetailAntrian;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranBerhasilActivity extends AppCompatActivity {
    TextView tvNamaLayanan, tvNamaDokter, tvNoAntrian, tvEstimasiWaktu,tvInfo;
    Bundle b;
    Toolbar tbPendaftaranBerhasil;
    SweetAlertDialog sdError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_berhasil);
        tvNamaLayanan = (TextView)findViewById(R.id.tv_pendaftaran_berhasil_nama_layanan);
        tvNamaDokter = (TextView)findViewById(R.id.tv_pendaftaran_berhasil_nama_dokter);
        tvNoAntrian = (TextView)findViewById(R.id.tv_nomor_antrian_poli_berhasil);
        tvEstimasiWaktu = (TextView)findViewById(R.id.tv_estimasi_waktu);
        tvInfo = (TextView)findViewById(R.id.tv_detail_info_poli);
        tbPendaftaranBerhasil = findViewById(R.id.tb_pendaftaran_berhasil);

        tbPendaftaranBerhasil.setTitle("");
        setSupportActionBar(tbPendaftaranBerhasil);
        b = getIntent().getExtras();

        String idAntrian = b.getString("idAntrian");

        sdError = new SweetAlertDialog(PendaftaranBerhasilActivity.this,SweetAlertDialog.ERROR_TYPE);


        //register local broadcast
//        LocalBroadcastManager.getInstance(this).registerReceiver(mHandler,new IntentFilter("com.sandec.fcm"));

        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

        Call<DetailAntrian> getDetailAntrian = service.getDetailAntrian(idAntrian);

        getDetailAntrian.enqueue(new Callback<DetailAntrian>() {
            @Override
            public void onResponse(Call<DetailAntrian> call, Response<DetailAntrian> response) {
                String namaLayanan = response.body().getNamaPoli();
                String namaDokter = response.body().getSubDesc();
                String noAntrian = response.body().getIdAntrian();
                String estimasiWaktu = response.body().getEstimasiWaktu();
                String info = response.body().getInfoTicket();
                tvNamaLayanan.setText(namaLayanan);
                tvNamaDokter.setText(namaDokter);
                tvNoAntrian.setText(noAntrian);
                tvEstimasiWaktu.setText(estimasiWaktu);
                tvInfo.setText(info);
            }

            @Override
            public void onFailure(Call<DetailAntrian> call, Throwable t) {
                sdError.setTitleText("Ops ..");
                sdError.setContentText("Ada masalah di Server");
                sdError.show();
//                Toast.makeText(PendaftaranBerhasilActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


//        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
//            NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//            NotificationChannel mChannel = new NotificationChannel(Konstanta.Channel_ID,
//                    Konstanta.Channel_NAME,importance);
//            mChannel.setDescription(Konstanta.Channel_DESCRIPTION);
//            mChannel.enableLights(true);
//            mChannel.setLightColor(Color.RED);
//            mChannel.enableVibration(true);
//            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
//            notificationManager.createNotificationChannel(mChannel);
//
//        }
    }

//    private BroadcastReceiver mHandler = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//        String message = intent.getStringExtra("message");
//        String response = intent.getStringExtra("response");
//
////            Toast.makeText(context, "Response : "+response+" ,"+"message : "+message, Toast.LENGTH_SHORT).show();
//            Log.d("notif", "onReceive: "+message);
//        }
//    };

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
////        startActivity(new Intent(this,MainActivity.class));
//        finish();
//    }

    @Override
    protected void onPause() {
        super.onPause();
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandler);
    }
}
