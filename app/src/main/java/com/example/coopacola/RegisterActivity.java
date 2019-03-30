package com.example.coopacola;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.coopacola.Fragment.View.FirstFormRegister;
import com.example.coopacola.Interface.Presenter.IRegisterPresenter;
import com.example.coopacola.Interface.View.IFormRegister1View;
import com.example.coopacola.Model.User;
import com.example.coopacola.UI.Adapter.Animation.AnimationPageTransformer;
import com.example.coopacola.UI.Adapter.CustomStyle.NonSwipeableViewPager;
import com.example.coopacola.UI.Adapter.ScreenSlidePageAdapter;

import java.util.List;

public class RegisterActivity extends FragmentActivity implements IRegisterPresenter  {

    private static final int num_page = 2;
    private NonSwipeableViewPager mPager;
    private ScreenSlidePageAdapter pagerAdapter;
    private Button btnNext;
    private Button btnBack;
    private Fragment firstFormRegister;
    private User user;


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnNext = (Button) findViewById(R.id.btnContinue);
        btnBack = (Button) findViewById(R.id.btnBack);
        mPager = (NonSwipeableViewPager) findViewById(R.id.viewPagerRegister);
        pagerAdapter = new ScreenSlidePageAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new AnimationPageTransformer());
        firstFormRegister = pagerAdapter.getItem(0);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FirstFormRegister)firstFormRegister).getData();
                if(user.getFullName() != null){
                    Log.d("User id = ", "found: ");
                }else{
                    Log.d("User id = ", "fa" + user.getFullName());
                }
                int checkError = user.validityForm1();
                Log.d("check Error Status :", Integer.toString(checkError));
                if(mPager.getCurrentItem() == 0 && checkError  == 0 ) {//== 0
                    mPager.setPagingEnabled(true);
                    mPager.setCurrentItem(1);
                }else{
                    if(mPager.getCurrentItem() > 1){
                        mPager.setPagingEnabled(false);
                        mPager.setCurrentItem(1);
                    }else{
                        if(firstFormRegister != null && firstFormRegister.isVisible()){
                            switch (checkError){
                                case 1 : ((FirstFormRegister)firstFormRegister).onErrorChangeFullNameUI();
                                    break;
                                case 2 : ((FirstFormRegister)firstFormRegister).onErrorChangeEmailUI();
                                    break;
                                case 3 : ((FirstFormRegister)firstFormRegister).onErrorChangeCardTypeUI();
                                    break;
                                case 4 : ((FirstFormRegister)firstFormRegister).onErrorChangeCardNumberUI();
                                    break;
                                case 5 : ((FirstFormRegister)firstFormRegister).onErrorChangeMotherNameUI();
                                    break;
                                case 6 : ((FirstFormRegister)firstFormRegister).onErrorChangeJobUI();
                                    break;
                                case 7 : ((FirstFormRegister)firstFormRegister).onErrorChangeAddressUI();
                                    break;
                                case 8 : ((FirstFormRegister)firstFormRegister).onErrorChangeCountryUI();
                                    break;
                            }
                            ((FirstFormRegister)firstFormRegister).onRefresh();
                        }
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setPagingEnabled(true);
                if(mPager.getCurrentItem() == 1){
                    mPager.setCurrentItem(0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onFirstFormComplete(String email, String idCardType, String idCardNumber, String fullName, String motherName, String gender, String job, String address, String country) {

    }

    @Override
    public void onSecondFormComplete(String idKoperasi) {

    }

    @Override
    public void sendUserData(User user) {
        this.user = user;
    }

}
