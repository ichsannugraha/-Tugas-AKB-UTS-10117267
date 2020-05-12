package com.ichsannugraha.tugasutsakb10117267;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ichsannugraha.tugasutsakb10117267.Adapter.SlidePagerAdapter;
import com.ichsannugraha.tugasutsakb10117267.Fragments.KontakFragment;
import com.ichsannugraha.tugasutsakb10117267.Fragments.ProfileFragment;
import com.ichsannugraha.tugasutsakb10117267.Fragments.TemanFragment;
import com.ichsannugraha.tugasutsakb10117267.Fragments.TentangAplikasiFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List<Fragment> list = new ArrayList<>();
        //list.add(new TentangAplikasiFragment());
        //list.add(new ProfileFragment());
        //list.add(new KontakFragment());
        //list.add(new TemanFragment());

        //viewPager = findViewById(R.id.pager);
        //pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        //viewPager.setAdapter(pagerAdapter);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_teman);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TemanFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_kontak:
                            selectedFragment = new KontakFragment();
                            break;
                        case R.id.nav_teman:
                            selectedFragment = new TemanFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}


/*
    Tanggal Pengerjaan  : 5/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */