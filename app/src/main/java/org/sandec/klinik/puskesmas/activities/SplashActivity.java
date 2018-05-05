package org.sandec.klinik.puskesmas.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.ResponServer;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean kirim = getSharedPreferences("token",MODE_PRIVATE).getBoolean("id",false);

        if(kirim){
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
            return;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean kirimState = getSharedPreferences("token",MODE_PRIVATE).getBoolean("id",false);
                SharedPreferences sp = getSharedPreferences(Konstanta.FIREBASE,MODE_PRIVATE);
                String idToken = sp.getString(Konstanta.TOKEN_FIREBASE,"");

                if(!idToken.isEmpty()&&!kirimState) {
                    getSharedPreferences("token",MODE_PRIVATE).edit().putBoolean("id",true).commit();

                    ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

                    Call<ResponServer> sendId = service.getResponseIdReg(idToken);

                    sendId.enqueue(new Callback<ResponServer>() {
                        @Override
                        public void onResponse(Call<ResponServer> call, Response<ResponServer> response) {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }

                        @Override
                        public void onFailure(Call<ResponServer> call, Throwable t) {
                            Toast.makeText(SplashActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }else if(kirimState){
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(SplashActivity.this, "Sistem belum berhasil meregister id hp Anda", Toast.LENGTH_SHORT).show();
                }

            }
        }, 8000);

    }
}
