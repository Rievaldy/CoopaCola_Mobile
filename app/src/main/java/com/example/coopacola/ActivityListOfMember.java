package com.example.coopacola;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.coopacola.Model.User;
import com.example.coopacola.UI.Adapter.JsonUserHelper;
import com.example.coopacola.UI.Adapter.RecycleViewAdapterListOfMember;

import java.util.ArrayList;

public class ActivityListOfMember extends AppCompatActivity {
    private ArrayList<User> listOfUser ;
    private static final String TAG = "ActivityListOfMember";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofmamber);
        initResource();
    }

    public void initResource(){
        JsonUserHelper jsonUserHelper = new JsonUserHelper(this,"data.json");
        listOfUser = jsonUserHelper.readFile();
        initRecycleView();
    }

    private void initRecycleView(){
        if(this != null){
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerViewListOfMember);
            recyclerView.setLayoutManager(layoutManager);
            RecycleViewAdapterListOfMember adapter = new RecycleViewAdapterListOfMember(this , listOfUser);
            recyclerView.setAdapter(adapter);
        }else{
            Log.d(TAG, "initRecycleView: view null");
        }

    }

}
