package com.example.coopacola.Model;

import com.example.coopacola.Interface.Model.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class User implements IUser, Serializable {
    private String id;
    private String email;
    private String idCardType;
    private String idCardNumber;
    private String fullName;
    private String motherName;
    private String confirmationEmail;
    private String gender;
    private String job;
    private String address;
    private String country;
    private String phone1;
    private String phone2;
    private String statusAnggota;
    private String jabatanAnggota;
    private String photoUrl;
    private String createAt;
    private String updateAt;
    private String idKoperasi;

    public User() {
    }

    public User(String id, String email, String idCardType, String idCardNumber, String fullName, String motherName, String confirmationEmail, String gender, String job, String address, String country, String phone1, String phone2, String statusAnggota, String jabatanAnggota, String photoUrl, String createAt, String updateAt, String idKoperasi) {
        this.id = id;
        this.email = email;
        this.idCardType = idCardType;
        this.idCardNumber = idCardNumber;
        this.fullName = fullName;
        this.motherName = motherName;
        this.confirmationEmail = confirmationEmail;
        this.gender = gender;
        this.job = job;
        this.address = address;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.statusAnggota = statusAnggota;
        this.jabatanAnggota = jabatanAnggota;
        this.photoUrl = photoUrl;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.idKoperasi = idKoperasi;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    @Override
    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    @Override
    public String getConfirmationEmail() {
        return confirmationEmail;
    }

    public void setConfirmationEmail(String confirmationEmail) {
        this.confirmationEmail = confirmationEmail;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @Override
    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Override
    public String getStatusAnggota() {
        return statusAnggota;
    }


    @Override
    public String getIdKoperasi() {
        return idKoperasi;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }

    @Override
    public String getJabatanAnggota() {
        return jabatanAnggota;
    }

    public void setJabatanAnggota(String jabatanAnggota) {
        this.jabatanAnggota = jabatanAnggota;
    }

    @Override
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public int validityForm1() {
        if(fullName == null || fullName.isEmpty() ) return 1;
        if(email == null || email.isEmpty()) return 2;
        if(idCardType == null || idCardType.isEmpty()) return 3;
        if(idCardNumber == null || idCardNumber.isEmpty()) return 4;
        if(motherName == null || motherName.isEmpty()) return 5;
        if(job == null || job.isEmpty()) return 6;
        if(address == null || address.isEmpty()) return 7;
        if(country == null || country.isEmpty() ) return 8;

        return 0;
    }


}
