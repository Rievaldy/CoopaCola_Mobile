package com.example.coopacola.UI.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.coopacola.Fragment.View.FirstFormRegister;
import com.example.coopacola.Fragment.SecondFormRegister;

public class ScreenSlidePageAdapter extends FragmentPagerAdapter {
    Fragment firstForm,secondForm;

    public ScreenSlidePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "FormRegister1";
        } else {
            title = "FormRegister2";
        }
        return title;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :if(firstForm == null){
                        firstForm = new FirstFormRegister();}
                return firstForm;
            case 1 :if(secondForm == null){
                secondForm = new SecondFormRegister();}
                return secondForm;
        }
        return secondForm;
    }

    @Override
    public int getCount() {
        //return num_page;
        return 2;
    }
}