package com.example.xl.wanandroidmvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.xl.wanandroidmvp.ui.fragment.Tab1Fragment;
import com.example.xl.wanandroidmvp.ui.fragment.Tab2Fragment;
import com.example.xl.wanandroidmvp.ui.fragment.Tab3Fragment;
import com.example.xl.wanandroidmvp.ui.fragment.Tab4Fragment;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private int number;
    private Tab1Fragment mTab1Fragment;
    private Tab2Fragment mTab2Fragment;
    private Tab3Fragment mTab3Fragment;
    private Tab4Fragment mTab4Fragment;

    public MyPagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number=number;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (mTab1Fragment==null){
                    mTab1Fragment = new Tab1Fragment();
                }
                return mTab1Fragment;
            case 1:
                if (mTab2Fragment==null){
                    mTab2Fragment = new Tab2Fragment();
                }
                return mTab2Fragment;
            case 2:
                if (mTab3Fragment==null){
                    mTab3Fragment = new Tab3Fragment();
                }
                return mTab3Fragment;
            case 3:
                if (mTab4Fragment==null){
                    mTab4Fragment = new Tab4Fragment();
                }
                return mTab4Fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return number;
    }

}
