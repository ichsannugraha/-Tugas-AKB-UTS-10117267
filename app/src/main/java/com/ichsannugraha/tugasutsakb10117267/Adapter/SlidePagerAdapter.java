package com.ichsannugraha.tugasutsakb10117267.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public SlidePagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}


/*
    Tanggal Pengerjaan  : 5/12/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */