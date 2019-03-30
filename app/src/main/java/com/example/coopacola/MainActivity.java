package com.example.coopacola;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.coopacola.Fragment.FragmentAkun;
import com.example.coopacola.Fragment.FragmentHome;
import com.example.coopacola.Fragment.FragmentKoperasiKu;
import com.example.coopacola.Fragment.FragmentMarket;
import com.example.coopacola.Fragment.FragmentTransaksi;
import com.example.coopacola.Model.User;
import com.example.coopacola.UI.Adapter.JsonUserHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<User> listOfUser = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        listOfUser.add(new User("1","joni","joni123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        listOfUser.add(new User("2","Sukirman","sukirman123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        listOfUser.add(new User("3","Jeremi","jeremi123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        listOfUser.add(new User("4","joni","joni123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        listOfUser.add(new User("5","Sukirman","sukirman123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        listOfUser.add(new User("6","Jeremi","jeremi123",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        JsonUserHelper jsonUserHelper = new JsonUserHelper(this, "data.json", listOfUser);
        jsonUserHelper.writeFile();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home :
                            selectedFragment = new FragmentHome();
                            break;
                        case R.id.nav_koperasi :
                            selectedFragment = new FragmentKoperasiKu();
                            break;
                        case R.id.nav_market :
                            selectedFragment = new FragmentMarket();
                            break;
                        case R.id.nav_transaksi :
                            selectedFragment = new FragmentTransaksi();
                            break;
                        case R.id.nav_akun :
                            selectedFragment = new FragmentAkun();
                            break;
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.navbar_container,selectedFragment)
                            .commit();

                    return true;
                }
            };
}
