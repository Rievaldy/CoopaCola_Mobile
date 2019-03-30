package com.example.coopacola.Interface.Model;

public interface IUser {
    String getId();
    String getEmail();
    String getIdCardType();
    String getIdCardNumber();
    String getFullName();
    String getMotherName();
    String getConfirmationEmail();
    String getGender();
    String getJob();
    String getPhone1();
    String getPhone2();
    String getAddress();
    String getCountry();
    String getPhotoUrl();
    String getJabatanAnggota();
    String getStatusAnggota();
    String getIdKoperasi();
    String getCreateAt();
    String getUpdateAt();

    public int validityForm1();

}
