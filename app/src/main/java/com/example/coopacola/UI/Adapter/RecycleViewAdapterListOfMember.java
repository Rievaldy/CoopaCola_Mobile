package com.example.coopacola.UI.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.coopacola.InfoBadanUsahaActivity;
import com.example.coopacola.InfoMemberActivity;
import com.example.coopacola.Model.BadanUsaha;
import com.example.coopacola.Model.User;
import com.example.coopacola.R;

import java.util.ArrayList;

public class RecycleViewAdapterListOfMember  extends RecyclerView.Adapter<RecycleViewAdapterListOfMember.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<User> listOfUser ;
    private Context context;
    private Context activity;

    public RecycleViewAdapterListOfMember( Context context, ArrayList<User> listOfUser){
        this.listOfUser = listOfUser;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cardview_listofmember, parent, false);
        activity = parent.getContext();
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int position) {
        //Glide.with(context).asBitmap().load(Users.get(position).getResourceImage()).into(viewHolder.imageView);
        viewHolder.idUser.setText(listOfUser.get(position).getId());
        viewHolder.namaUser.setText(listOfUser.get(position).getFullName());
        viewHolder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoMemberActivity fragmentInfoMember = new InfoMemberActivity();
                Intent intent = new Intent(activity, fragmentInfoMember.getClass());
                intent.putExtra("member", listOfUser.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfUser.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView idUser,namaUser;
        Button show, delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView = itemView.findViewById(R.id.imageUser);
            idUser = itemView.findViewById(R.id.listOfID);
            namaUser = itemView.findViewById(R.id.listOfUserName);
            delete = itemView.findViewById(R.id.listOfMemberBtnDelete);
            show = itemView.findViewById(R.id.listOfMemberBtnShowInformation);
        }
    }

}
