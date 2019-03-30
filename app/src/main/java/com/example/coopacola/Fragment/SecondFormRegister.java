package com.example.coopacola.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.coopacola.Model.BadanUsaha;
import com.example.coopacola.R;
import com.example.coopacola.RegisterActivity;
import com.example.coopacola.UI.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class SecondFormRegister extends Fragment {

    private ArrayList<BadanUsaha> badanUsahas = new ArrayList<>();
    private static final String TAG = "SecondFormRegister";
    private View views;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        views = getView();
        initResource();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_register_form2, container, false);
        return view;
    }

    private void initResource() {
        for (int i = 0; i < 10; i++) {
            BadanUsaha badanUsaha = new BadanUsaha("PT.Sejahtera", "jl. jalan ajah", "https://fajarhidayatulloh990.files.wordpress.com/2016/11/small-business.jpg?w=712");
            badanUsahas.add(badanUsaha);
        }
        initRecycleView();
    }

    private void initRecycleView(){
        if(getView() != null){
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycleViewBadanUsaha);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity().getApplicationContext() , badanUsahas);
            recyclerView.setAdapter(adapter);
        }else{
            Log.d(TAG, "initRecycleView: view null");
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: ");
    }
}