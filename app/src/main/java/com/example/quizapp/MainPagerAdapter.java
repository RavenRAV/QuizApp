package com.example.quizapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
    MainFragment fragment0 = new MainFragment();
    Fragment2 fragment1 = new Fragment2();
    Fragment3 fragment2 = new Fragment3();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragment0;
            case 1:
                return fragment1;
            case 2:
                return fragment2;
            default:
                return fragment0;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
