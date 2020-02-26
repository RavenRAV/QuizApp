package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager = findViewById(R.id.viewPager);
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.first).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.second).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.third).setChecked(true);
                        break;
                }
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.first:
                            viewPager.setCurrentItem(0);
                            return true;
                        case R.id.second:
                            viewPager.setCurrentItem(1);
                            return true;
                        case R.id.third:
                            viewPager.setCurrentItem(2);
                            return true;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragment).commit();
                    return true;
                }
            };
}
