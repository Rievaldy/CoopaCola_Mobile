package com.example.coopacola.Presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.coopacola.Interface.Model.IUser;
import com.example.coopacola.Interface.Model.IUserPass;
import com.example.coopacola.Interface.Presenter.ILoginPresenter;
import com.example.coopacola.Interface.View.ILoginView;
import com.example.coopacola.Model.User;
import com.example.coopacola.Model.UserPass;

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;
    IUserPass user;
    Handler handler;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String id, String password) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(id,password);

        if(code!=0) isLoginSuccess = false;

        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        },5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressVisibility(visibility);
    }

    private void initUser(){
        user = new UserPass("mvp","mvp","mvp", null);
    }
}
