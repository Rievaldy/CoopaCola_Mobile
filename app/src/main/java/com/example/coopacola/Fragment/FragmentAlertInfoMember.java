package com.example.coopacola.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coopacola.Model.BadanUsaha;
import com.example.coopacola.Model.User;
import com.example.coopacola.R;

import java.io.InputStream;

public class FragmentAlertInfoMember extends Fragment {
    private User user;
    TextView id,nama;
    ImageView fotoBadanUsaha;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alert_more_info_badan_usaha,container,false);
        return view;
    }

    public void initData(){
        //id = getView().findViewById(R.id.titleNamaMember);
        nama = getView().findViewById(R.id.titleNamaMember);
        //fotoBadanUsaha = getView().findViewById(R.id.fotoProfileMember);
        //id.setText(user.getId());
        nama.setText(user.getFullName());
        //new DownloadImageTask(fotoBadanUsaha).execute(badanUsaha.getResourceImage());
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}