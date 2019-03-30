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
import com.example.coopacola.R;

import java.io.InputStream;

public class FragmentAlertInfoBadanUsaha extends Fragment {
    private BadanUsaha badanUsaha;
    TextView nama,lokasi;
    ImageView fotoBadanUsaha;

    public void setBadanUsaha(BadanUsaha badanUsaha) {
        this.badanUsaha = badanUsaha;
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
        nama = getView().findViewById(R.id.titleNamaMember);
        lokasi = getView().findViewById(R.id.AlamatMember);
        fotoBadanUsaha = getView().findViewById(R.id.fotoProfileMember);
        nama.setText(badanUsaha.getNama());
        lokasi.setText(badanUsaha.getLokasi());
        new DownloadImageTask(fotoBadanUsaha).execute(badanUsaha.getResourceImage());
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
