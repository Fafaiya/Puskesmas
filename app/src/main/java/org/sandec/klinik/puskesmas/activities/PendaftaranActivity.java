package org.sandec.klinik.puskesmas.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.sandec.klinik.puskesmas.R;

public class PendaftaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        getSupportActionBar().setTitle("Daftar");
    }

    public void daftar(View view) {

    }
}
