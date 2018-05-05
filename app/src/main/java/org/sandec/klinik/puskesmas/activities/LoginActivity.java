package org.sandec.klinik.puskesmas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.sandec.klinik.puskesmas.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
    }

    public void loginPuskesmas(View view) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
