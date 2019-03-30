package com.example.coopacola.UI.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.coopacola.InfoBadanUsahaActivity;
import com.example.coopacola.Model.BadanUsaha;
import com.example.coopacola.R;

import java.util.ArrayList;


public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<BadanUsaha> badanUsahas = new ArrayList<>();
    private Context context;
    private Context activity;

    public RecyclerViewAdapter( Context context, ArrayList<BadanUsaha> badanUsahas){
        this.badanUsahas = badanUsahas;
        this.context = context;

        Log.d(TAG, "RecyclerViewAdapter: " + badanUsahas.get(0).getResourceImage());
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cardview_badan_usaha, parent, false);
        activity = parent.getContext();
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int position) {
        Glide.with(context).asBitmap().load(badanUsahas.get(position).getResourceImage()).into(viewHolder.imageView);
        viewHolder.namaBadanUsaha.setText(badanUsahas.get(position).getNama());
        viewHolder.lokasi.setText(badanUsahas.get(position).getLokasi());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: image " + badanUsahas.get(position).getResourceImage());
                Toast.makeText(context,badanUsahas.get(position).getNama(), Toast.LENGTH_SHORT).show();
                InfoBadanUsahaActivity fragmentInfoBadanUsaha = new InfoBadanUsahaActivity();
                Intent intent = new Intent(activity, fragmentInfoBadanUsaha.getClass());
                intent.putExtra("badanUsaha", badanUsahas.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return badanUsahas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView namaBadanUsaha,lokasi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageBadanUsaha);
            namaBadanUsaha = itemView.findViewById(R.id.txtNamaBadanUsaha);
            lokasi = itemView.findViewById(R.id.txtLokasiBadanUsaha);
        }
    }

}