package org.sandec.klinik.puskesmas.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chaos.view.PinView;

import org.sandec.klinik.puskesmas.R;

public class ValidasiPendaftaranActivity extends AppCompatActivity {
PinView pvNoValidasi;
Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validasi_pendaftaran);
        pvNoValidasi = (PinView)findViewById(R.id.no_validasi);
        b = getIntent().getExtras();
    }

//    public void verified(View view) {
//        final ProgressDialog db = new ProgressDialog(this);
//        db.setMessage("Checking ...");
//        db.show();
//
//        String noValidasi = pvNoValidasi.getText().toString();
//        ServiceClient service = ServiceGenerator.createService(ServiceClient.class);
//        if(noValidasi.isEmpty()){
//            db.dismiss();
//            Toast.makeText(this, "isi dulu no validasinya", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Call<Validasi>getValidasi = service.getValidate("validate","validasi",b.getString(Konstanta.NIK),noValidasi);
//
//        getValidasi.enqueue(new Callback<Validasi>() {
//            @Override
//            public void onResponse(Call<Validasi> call, Response<Validasi> response) {
//                db.dismiss();
//                String hasil = response.body().getHasil();
//                if(hasil.equals("Maaf no validasi salah")){
//                    Toast.makeText(ValidasiPendaftaranActivity.this, "No validasi salah", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Toast.makeText(ValidasiPendaftaranActivity.this, hasil, Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ValidasiPendaftaranActivity.this,MainActivity.class));
//                finish();
//            }
//
//            @Override
//            public void onFailure(Call<Validasi> call, Throwable t) {
//                db.dismiss();
//                Toast.makeText(ValidasiPendaftaranActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
