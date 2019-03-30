package com.example.coopacola.Interface.Presenter;

import java.util.Map;

public interface ILoginPresenter {
    public void clear();
    public void doLogin(String id, String password);
    public void setProgressBarVisibility(int visibility);
}
