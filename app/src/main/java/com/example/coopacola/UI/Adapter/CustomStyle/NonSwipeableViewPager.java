package com.example.coopacola.UI.Adapter.CustomStyle;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

public class NonSwipeableViewPager extends ViewPager {
    private boolean enabled;

    public NonSwipeableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(this.enabled){
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(this.enabled){
            return super.onTouchEvent(ev);
        }
        return false;
    }

    public void setPagingEnabled(boolean enabled){
        this.enabled = enabled;
    }

    private void setMyscroller(){
        try{
            Class<?> viewPager = ViewPager.class;
            Field scroller = viewPager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new SmoothScrooling(getContext()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public class SmoothScrooling extends Scroller{

        public SmoothScrooling(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 350);
        }
    }
}
