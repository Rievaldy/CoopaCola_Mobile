package com.example.coopacola.Model;

import com.example.coopacola.Interface.Model.IBadanUsaha;

import java.io.Serializable;

public class BadanUsaha implements IBadanUsaha, Serializable {
    private String nama;
    private String lokasi;
    private String resourceImage;

    public BadanUsaha(String nama, String lokasi, String resourceImage){
        this.nama = nama;
        this.lokasi = lokasi;
        this.resourceImage = resourceImage;
    }

    @Override
    public String getResourceImage() {
        return resourceImage;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }
}
