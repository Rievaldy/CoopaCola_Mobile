package com.example.coopacola.Interface.View;

import com.example.coopacola.Model.User;

public interface IFormRegister1View {
    void onErrorChangeFullNameUI();
    void onErrorChangeEmailUI();
    void onErrorChangeMotherNameUI();
    void onErrorChangeCardTypeUI();
    void onErrorChangeCardNumberUI();
    void onErrorChangeJobUI();
    void onErrorChangeGenderUI();
    void onErrorChangeAddressUI();
    void onErrorChangeCountryUI();
    void onHideErrorMessage();
    void getData();
    void onRefresh();
}
