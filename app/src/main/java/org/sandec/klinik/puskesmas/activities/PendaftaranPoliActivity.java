package org.sandec.klinik.puskesmas.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import org.sandec.klinik.puskesmas.R;
import org.sandec.klinik.puskesmas.model.Antrian;
import org.sandec.klinik.puskesmas.model.TambahAntrianResponse;
import org.sandec.klinik.puskesmas.network.ServiceClient;
import org.sandec.klinik.puskesmas.network.ServiceGenerator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranPoliActivity extends AppCompatActivity {
    TextView tvNamaLayanan, tvNamaDokter, tvNoAntrian, tvNoAntrianBelum,tvDetailPoli;
    EditText etNik;
    Toolbar tbPendaftaranPoli;
    RadioGroup rgJenisLayanan, rgTanggalDaftar;
    RadioButton rbBpjsPoli;
    String nik, daftarTgl;
    Button btnDaftarPoli;
    String idPoli;
    String detailPoli;
    String layananId;
    String noAntrianTerakhir;
    SweetAlertDialog sdError;
    SweetAlertDialog sdSukses;
    ServiceClient service;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_poli);

        b = getIntent().getExtras();

        //dapatkan nama poli
//        namaPoli = b.getString(Konstanta.NAMA_POLI);
//        namaDokter = b.getString(Konstanta.NAMA_DOKTER);


        layananId = b.getString(Konstanta.LAYANAN_ID,"");

        tvNamaLayanan = (TextView) findViewById(R.id.tv_pendaftaran_poli_nama_layanan);
        tvNamaDokter = (TextView) findViewById(R.id.tv_pendaftaran_poli_nama_dokter);
        tvNoAntrian = (TextView) findViewById(R.id.tv_nomor_antrian_poli);
        tbPendaftaranPoli = findViewById(R.id.tb_pendaftaran_poli);
        tvNoAntrianBelum = (TextView) findViewById(R.id.tv_no_antrian_poli_blm_terpanggil);
//        tvDetailPoli = (TextView) findViewById(R.id.tv_detail_poli);
        etNik = (EditText) findViewById(R.id.et_nik_poli);
        rgJenisLayanan = (RadioGroup) findViewById(R.id.rg_jenis_layanan_poli);
        rgTanggalDaftar = (RadioGroup) findViewById(R.id.rg_tanggal_daftar_poli);
//        rbBpjsPoli = (RadioButton) findViewById(R.id.rb_bpjs);
//        rbBpjsPoli.setEnabled(false);
        btnDaftarPoli = (Button)findViewById(R.id.btn_daftar_poli);
        //btnDaftarPoli.setEnabled(false);

        tbPendaftaranPoli.setTitle("");
        setSupportActionBar(tbPendaftaranPoli);

        sdError = new SweetAlertDialog(PendaftaranPoliActivity.this,SweetAlertDialog.ERROR_TYPE);
        sdSukses = new SweetAlertDialog(PendaftaranPoliActivity.this,SweetAlertDialog.SUCCESS_TYPE);
        //mandapatkan detail poli
//        detailPoli = b.getString(Konstanta.DETAIL_POLI);
//        tvDetailPoli.setText(detailPoli);

        SharedPreferences sp = getSharedPreferences(Konstanta.FIREBASE,MODE_PRIVATE);
        String token = sp.getString(Konstanta.TOKEN_FIREBASE,"");

//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("load data from server");
//        pd.show();

        final SweetAlertDialog sd = new SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        sd.getProgressHelper().setBarColor(R.color.colorPrimary);
        sd.setTitleText("Load data from server");
        sd.setCancelable(false);
        sd.show();


        service = ServiceGenerator.createService(ServiceClient.class);

        //mendapatkan layanan id
//        idPoli = b.getString(Konstanta.LAYANAN_ID);

        Call<Antrian> readAntrian = service.getDaftarAntrian(layananId, "token");

        readAntrian.enqueue(new Callback<Antrian>() {
            @Override
            public void onResponse(Call<Antrian> call, Response<Antrian> response) {
                sd.dismiss();
                noAntrianTerakhir = response.body().getAntrianTerakhir();
                String jmlhAntrian = response.body().getJumlahAntrian();
                String namaLayanan = response.body().getJudul1();
                String namaDokter = response.body().getJudul2();
                tvNamaLayanan.setText(namaLayanan);
                tvNamaDokter.setText(namaDokter);
                tvNoAntrian.setText(noAntrianTerakhir);
                tvNoAntrianBelum.setText(jmlhAntrian);


//                getSupportActionBar().setTitle(namaLayanan+"/n"+namaDokter);
//                SharedPreferences sp = getSharedPreferences(Konstanta.PREF, MODE_PRIVATE);
//                String nikBaru = sp.getString(Konstanta.NIK, "");
//                etNik.setText(nikBaru);
            }

            @Override
            public void onFailure(Call<Antrian> call, Throwable t) {
                sd.dismiss();
//                Toast.makeText(PendaftaranPoliActivity.this, "koneksi ke server terputus" , Toast.LENGTH_SHORT).show();
                SweetAlertDialog sdError = new SweetAlertDialog(getApplicationContext(),SweetAlertDialog.ERROR_TYPE);
                sdError.setTitleText("Oops ...");
                sdError.setContentText("Koneksi ke server terputus");
            }
        });
    }

//    public void cekNIK(View view) {
//        if (etNik.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Mohon isi NIK nya", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Cek NIK");
//        pd.show();
//        nik = etNik.getText().toString().trim();
//
//        //filter NIK
//        ServiceClient cekNik = ServiceGenerator.createService(ServiceClient.class);
//
//        Call<ResponseCekNIK> getStatusNik= cekNik.cekNik(nik);
//
//        getStatusNik.enqueue(new Callback<ResponseCekNIK>() {
//            @Override
//            public void onResponse(Call<ResponseCekNIK> call, Response<ResponseCekNIK> response) {
//                pd.dismiss();
//                String nikRespon = response.body().getNik();
//                String bpjsRespon = response.body().getBpjs();
//                String nikMessage = response.body().getNikMessage();
//                String bpjsMessage = response.body().getBpjsMessage();
//
//                if(nikRespon.equals("0")&&bpjsRespon.equals("0")){
//                    daftarNik(nikMessage,bpjsMessage);
//                }else if(nikRespon.equals("1")&&bpjsRespon.equals("0")){
//                    Toast.makeText(PendaftaranPoliActivity.this, ""+nikMessage+" dan "+bpjsMessage, Toast.LENGTH_SHORT).show();
//                    btnDaftarPoli.setEnabled(true);
//                }else if(nikRespon.equals("1")&&bpjsRespon.equals("1")){
//                    Toast.makeText(PendaftaranPoliActivity.this, ""+nikMessage+" dan "+bpjsMessage, Toast.LENGTH_SHORT).show();
//                    btnDaftarPoli.setEnabled(true);
//                    rbBpjsPoli.setEnabled(true);
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseCekNIK> call, Throwable t) {
//                pd.dismiss();
//                Toast.makeText(PendaftaranPoliActivity.this, "Koneksi ke server terputus", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }



//    public void daftarPoliGigi(View view) {
//        //filter jika nik kosong
//        if (etNik.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Mohon isi NIK nya", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("register to server");
//        pd.show();
//        nik = etNik.getText().toString().trim();
//
//        //filter NIK
//        ServiceClient cekNik = ServiceGenerator.createService(ServiceClient.class);
//
//        Call<Validasi> getNikDukcapil = cekNik.getNIKDukcapil("cek_dukcapil", "server_dukcapil", nik);
//        getNikDukcapil.enqueue(new Callback<Validasi>() {
//            @Override
//            public void onResponse(Call<Validasi> call, Response<Validasi> response) {
//                pd.dismiss();
//                if (response.body().getHasil().equals("Nik tidak terdaftar")) {
//                    //daftar nik di dukcapil
//                    daftarNik();
//                } else if (response.body().getHasil().equals("Nik terdaftar")) {
//                    //daftar poli di puskesmas
//                    daftarPoli();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Validasi> call, Throwable t) {
//                pd.dismiss();
//                Toast.makeText(PoliGigiActivity.this, "Koneksi ke server terputus", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//

//
    private void daftarNik(String nikMessage, String bpjsMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pendaftaran NIK");
        builder.setMessage(nikMessage +" dan "+bpjsMessage);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Bundle ba = new Bundle();
                //mendapatkan list layanan id
                ba.putString(Konstanta.POLI, "gigi");
                Intent i = new Intent(PendaftaranPoliActivity.this, PendaftaranPuskesmasActivity.class);
                i.putExtras(ba);
                startActivity(i);
                finish();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(PendaftaranPoliActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.show();

    }


    public void daftarPoli(View view) {
        if (etNik.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Mohon isi NIK nya", Toast.LENGTH_SHORT).show();
            SweetAlertDialog sdError = new SweetAlertDialog(PendaftaranPoliActivity.this,SweetAlertDialog.ERROR_TYPE);
            sdError.setTitleText("Oops ...");
            sdError.setContentText("Mohon isi NIK nya ");
            sdError.show();
            return;
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mFormat = new SimpleDateFormat("dd/ MM / yyyy");
        int idRbLayanan = rgJenisLayanan.getCheckedRadioButtonId();
        int idRbDaftarPoli = rgTanggalDaftar.getCheckedRadioButtonId();
        RadioButton rbLayanan = (RadioButton) findViewById(idRbLayanan);
        RadioButton rbTanggalDaftarGigi = (RadioButton) findViewById(idRbDaftarPoli);
        String layanan = rbLayanan.getText().toString();

        //daftarTgl = rbTanggalDaftarGigi.getText().toString();
        if (idRbDaftarPoli == R.id.rb_daftar_hari_ini) {

            daftarTgl = "" + mFormat.format(calendar.getTime());

        } else {
            calendar.add(Calendar.DATE, 1);
            daftarTgl = "" + mFormat.format(calendar.getTime());
        }

        SharedPreferences idF = getSharedPreferences(Konstanta.FIREBASE, MODE_PRIVATE);

        String token = idF.getString(Konstanta.TOKEN_FIREBASE, "");

//        if(token.isEmpty()){
//            Toast.makeText(this, "token kosong", Toast.LENGTH_SHORT).show();
//            return;
//        }
        Log.d("data", "daftarPoli: "+layananId);
//        Log.d("data", "idPoli :"+layananId+"\n"
//                +"token :"+token+"\n"
//                +"layanana :"+layanan+"\n"
//                +"nik :"+etNik.getText()+"\n"
//                +"Tanggal :"+daftarTgl);

        service = ServiceGenerator.createService(ServiceClient.class);

        Call<ArrayList<TambahAntrianResponse>> getAntrian = service.getDaftarPoliResponse(3,token,"umum","123","0");

        getAntrian.enqueue(new Callback<ArrayList<TambahAntrianResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<TambahAntrianResponse>> call, Response<ArrayList<TambahAntrianResponse>> response) {
                if(!response.body().isEmpty()){
                    final String idAntrian = response.body().get(1).getAntrianID();
                    sdSukses.setTitleText("Pendaftaran Berhasil");
                    sdSukses.setContentText("Klik Ok untuk melanjutkan");
                    sdSukses.setConfirmText("OK");
                    sdSukses.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            Bundle b = new Bundle();

                            b.putString("idAntrian",idAntrian);
                            Intent i = new Intent(PendaftaranPoliActivity.this, PendaftaranBerhasilActivity.class);
                            i.putExtras(b);
                            startActivity(i);
                            finish();
                        }
                    });
                    sdSukses.show();
                }else{
//                    SweetAlertDialog sdError = new SweetAlertDialog(getApplicationContext(),SweetAlertDialog.ERROR_TYPE);
                    sdError.setTitleText("Oops ...");
                    sdError.setContentText("Pendaftaran gagal");
                    sdError.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TambahAntrianResponse>> call, Throwable t) {
                Log.d("error", "onFailure: "+t.getLocalizedMessage());
                sdError.setTitleText("Oops ...");
                sdError.setContentText("Ada masalah di Server");
                sdError.setConfirmText("Ok");
                sdError.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        startActivity(new Intent(PendaftaranPoliActivity.this,PendaftaranPoliActivity.class));
                        finish();
                    }
                });
                sdError.show();

            }
        });

//        Call<TambahAntrian> getAntrianPoli =service.getDaftarPoli(2,token,"umum","123",0);
//
//        getAntrianPoli.enqueue(new Callback<TambahAntrian>() {
//            @Override
//            public void onResponse(Call<TambahAntrian> call, Response<TambahAntrian> response) {
//                Toast.makeText(PendaftaranPoliActivity.this, "sukses", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<TambahAntrian> call, Throwable t) {
//                Toast.makeText(PendaftaranPoliActivity.this, "gagal", Toast.LENGTH_SHORT).show();
//            }
//        });
        //ServiceClient service = retrofit.create(ServiceClient.class);
//        Call<TambahAntrian> getAntrianPoli = service.getDaftarPoli(2 ,token, layanan,etNik.getText().toString().trim(), 0);

//        getAntrianPoli.enqueue(new Callback<TambahAntrian>() {
//            @Override
//            public void onResponse(Call<TambahAntrian> call, Response<TambahAntrian> response) {
//
//                if (response.body().getResponse().equals("success")) {
//
//                    final String idAntrian = response.body().getIdAntrian();
//                    sdSukses.setTitleText("Pendaftaran Berhasil");
//                    sdSukses.setContentText("Klik Ok untuk melanjutkan");
//                    sdSukses.setConfirmText("OK");
//                    sdSukses.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                            Bundle b = new Bundle();
//
//                            b.putString("idAntrian",idAntrian);
//                            Intent i = new Intent(PendaftaranPoliActivity.this, PendaftaranBerhasilActivity.class);
//                            i.putExtras(b);
//                            startActivity(i);
//                            finish();
//                        }
//                    });
//                    sdSukses.show();
//
//                } else if (response.body().getResponse().equals("error")) {
//                    SweetAlertDialog sdError = new SweetAlertDialog(getApplicationContext(),SweetAlertDialog.ERROR_TYPE);
//                    sdError.setTitleText("Oops ...");
//                    sdError.setContentText("Pendaftaran gagal");
//                    sdError.show();
//
////                    Toast.makeText(PendaftaranPoliActivity.this, "Pendaftaran gagal", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TambahAntrian> call, @NonNull Throwable t) {
//                Toast.makeText(PendaftaranPoliActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
////                SweetAlertDialog sdError = new SweetAlertDialog(getApplicationContext(),SweetAlertDialog.ERROR_TYPE);
////                sdError.setTitleText("Oops ...");
////                sdError.setContentText(""+t.getMessage());
////                sdError.show();
////                Toast.makeText(PendaftaranPoliActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
