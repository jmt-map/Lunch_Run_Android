package com.inauzu.lunchrun;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;

import com.inauzu.lunchrun.map.MapFragment;
import com.inauzu.lunchrun.review.ReviewFragment;
import com.inauzu.lunchrun.roulette.RouletteFragment;
import com.inauzu.lunchrun.setting.SettingFragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

    // 4개의 메뉴에 들어갈 Fragment들
    private RouletteFragment rouletteFragmentFragment = new RouletteFragment();
    private MapFragment mapFragment = new MapFragment();
    private ReviewFragment reviewFragment = new ReviewFragment();
    private SettingFragment settingFragment = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, rouletteFragmentFragment).commitAllowingStateLoss();

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_roulette: {
                        transaction.replace(R.id.frame_layout, rouletteFragmentFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_map: {
                        transaction.replace(R.id.frame_layout, mapFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_review: {
                        transaction.replace(R.id.frame_layout, reviewFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_setting: {
                        transaction.replace(R.id.frame_layout, settingFragment).commitAllowingStateLoss();
                        break;
                    }
                }

                return true;
            }
        });
    }
}