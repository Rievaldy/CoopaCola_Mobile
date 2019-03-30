package com.example.coopacola;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.coopacola.Fragment.FragmentAlertInfoBadanUsaha;
import com.example.coopacola.Model.BadanUsaha;

public class InfoBadanUsahaActivity extends AppCompatActivity {

    private BadanUsaha badanUsaha;
    Button close;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_main_badan_usaha);
        badanUsaha = (BadanUsaha) getIntent().getSerializableExtra("badanUsaha");

        FragmentAlertInfoBadanUsaha fragmentAlertInfoBadanUsaha = new FragmentAlertInfoBadanUsaha();
        fragmentAlertInfoBadanUsaha.setBadanUsaha(badanUsaha);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutInfoMember, fragmentAlertInfoBadanUsaha)
                .commit();
    close = findViewById(R.id.btnCloseMoreInfoMember);
    close.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });
    }
}
