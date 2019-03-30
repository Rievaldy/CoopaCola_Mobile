package com.example.coopacola.Interface.Presenter;

import com.example.coopacola.Model.User;


public interface IRegisterPresenter {
    public void onFirstFormComplete(String email,
                                    String idCardType,
                                    String idCardNumber,
                                    String fullName,
                                    String motherName,
                                    String gender,
                                    String job,
                                    String address,
                                    String country);
    public void onSecondFormComplete(String idKoperasi);

    public void sendUserData(User user);
}
