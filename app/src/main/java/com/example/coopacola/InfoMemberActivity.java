package com.example.coopacola;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.coopacola.Fragment.FragmentAlertInfoBadanUsaha;
import com.example.coopacola.Fragment.FragmentAlertInfoMember;
import com.example.coopacola.Model.BadanUsaha;
import com.example.coopacola.Model.User;

public class InfoMemberActivity extends AppCompatActivity {

    private User user;
    Button close;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_main_badan_usaha);
        user = (User) getIntent().getSerializableExtra("member");

        FragmentAlertInfoMember fragmentAlertInfoMember = new FragmentAlertInfoMember();
        fragmentAlertInfoMember.setUser(user);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayoutInfoMember, fragmentAlertInfoMember)
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
