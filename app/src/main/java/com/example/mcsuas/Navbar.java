package com.example.mcsuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Navbar extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        meowBottomNavigation = findViewById(R.id.navbar_meowNavbar);
        meowBottomNavigation.show(1,true);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.round_home_24));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_notifications_active_24));

        meowBottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment fragment =null;

                switch (model.getId()){
                    case 1:
                        fragment = new FragmentHome();
                        break;
                    case 2:
                        fragment = new FragmentNotification();
                        break;
                }
                loadFragment(fragment);
                return null;
            }
        });

    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.navbar_frameLay, fragment).commit();
    }
}