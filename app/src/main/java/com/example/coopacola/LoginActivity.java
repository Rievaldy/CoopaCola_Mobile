package com.example.coopacola;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coopacola.Interface.Presenter.ILoginPresenter;
import com.example.coopacola.Interface.View.ILoginView;
import com.example.coopacola.Presenter.LoginPresenter;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private TextView register;
    private EditText inputId;
    private EditText inputPassword;
    private Button loginBtn;
    private ILoginPresenter loginPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView)findViewById(R.id.register);
        inputId = (EditText) findViewById(R.id.inputId);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBarLogin);

        loginBtn.setOnClickListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginPresenter = new LoginPresenter(this);
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v) {
        loginPresenter.setProgressBarVisibility(View.VISIBLE);
        loginBtn.setEnabled(false);
        loginPresenter.doLogin(inputId.getText().toString(),inputPassword.getText().toString());
    }

    @Override
    public void onClearText() {

    }

    @Override
    public void onLoginResult(boolean result, int code) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        loginBtn.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetProgressVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
