package com.tangeamseng.foodsstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation =findViewById(R.id.bottom_nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.view_pager,new Home()).commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Home();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_favorite:
                    fragment = new Favorite();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new Fragment3();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = new Fragment4();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
        private void loadFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.view_pager,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    };
}