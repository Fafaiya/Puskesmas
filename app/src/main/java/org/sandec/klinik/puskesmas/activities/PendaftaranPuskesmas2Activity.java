package org.sandec.klinik.puskesmas.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.ResponServer;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranPuskesmas2Activity extends AppCompatActivity {
    EditText etNik, etNama, etAlamat, etTanggalLahir, etTelp, etBpjs;
    RadioGroup rgJenisKelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_puskesmas2);
        etNik = (EditText) findViewById(R.id.et_daftar_puskesmas_nik2);
        etNama = (EditText) findViewById(R.id.et_daftar_puskesmas_nama2);
        etAlamat = (EditText) findViewById(R.id.et_daftar_puskesmas_alamat2);
        etTanggalLahir = (EditText) findViewById(R.id.et_daftar_puskesmas_tanggal_lahir2);
        etTelp = (EditText) findViewById(R.id.et_daftar_puskesmas_no_telp2);
        etBpjs = (EditText) findViewById(R.id.et_daftar_puskesmas_no_bpjs2);
        rgJenisKelamin = (RadioGroup) findViewById(R.id.rg_jenis_kelamin2);
    }

    public void daftarPuskesmas(View view) {
        if (validate()) {

            SharedPreferences sp = getSharedPreferences(Konstanta.LOGIN, MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(Konstanta.DAFTAR, true);
            editor.commit();

            final ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage("register to server");
            pd.show();

            SharedPreferences idF = getSharedPreferences(Konstanta.FIREBASE,MODE_PRIVATE);

            String token = idF.getString(Konstanta.TOKEN_FIREBASE,"");


            ServiceClient service = ServiceGenerator.createService(ServiceClient.class);

            final String nik = etNik.getText().toString().trim();
            String nama = etNama.getText().toString().trim();
            String alamat = etAlamat.getText().toString().trim();
            String tl = etTanggalLahir.getText().toString().trim();
            String telp = etTelp.getText().toString().trim();
            String bpjs = etBpjs.getText().toString().trim();
            int idRb = rgJenisKelamin.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton) findViewById(idRb);
            String jenisKelamin = rb.getText().toString();
            Call<ResponServer> getDaftar = service.getDaftar(nik,nama,alamat,tl,telp,bpjs,jenisKelamin);


            getDaftar.enqueue(new Callback<ResponServer>() {
                @Override
                public void onResponse(Call<ResponServer> call, Response<ResponServer> response) {
                    pd.dismiss();
                    String hasil = response.body().getMessage();
                    Toast.makeText(PendaftaranPuskesmas2Activity.this, ""+hasil, Toast.LENGTH_SHORT).show();
                    Bundle b = new Bundle();
                    b.putString("coba","poli");

                    Intent i = new Intent(PendaftaranPuskesmas2Activity.this, MainActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }

                @Override
                public void onFailure(Call<ResponServer> call, Throwable t) {
                    pd.dismiss();
                    Toast.makeText(PendaftaranPuskesmas2Activity.this, "Koneksi ke server terputus", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

    public boolean validate() {

        if (etNik.getText().toString().isEmpty() &&
                etNama.getText().toString().isEmpty() &&
                etAlamat.getText().toString().isEmpty() &&
                etTanggalLahir.getText().toString().isEmpty() &&
                etTelp.getText().toString().isEmpty() &&
                etBpjs.getText().toString().isEmpty()) {
            Toast.makeText(this, "Mohon diisi data yang masih kosong", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etNik.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi NIK nya", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etNama.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi namanya nya", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etAlamat.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi alamat nya", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etTanggalLahir.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi tanggal lahir nya", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etTelp.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi no telp nya", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etBpjs.getText().toString().isEmpty()) {
            Toast.makeText(this, "mohon diisi no BPJS nya", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;

    }
}
