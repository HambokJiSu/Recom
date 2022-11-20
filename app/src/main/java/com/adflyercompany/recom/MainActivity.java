package com.adflyercompany.recom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FragmentStateAdapter fragmentStateAdapter;

    private FragmentHome fragHome;
    private FragmentPartners fragPartners;
    private FragmentService fragService;
    private FragmentReview fragReview;
    private FragmentQnA fragQnA;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFragment();

        createViewpager();

        settingTabLayout();
    }

    private void createFragment(){
        fragHome = new FragmentHome();
        fragPartners = new FragmentPartners();
        fragService = new FragmentService();
        fragReview = new FragmentReview();
        fragQnA = new FragmentQnA();
    }

    private void createViewpager(){
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        fragmentStateAdapter = new FragmentStateAdapter(getSupportFragmentManager(), getLifecycle());
        fragmentStateAdapter.addFragment(fragHome);
        fragmentStateAdapter.addFragment(fragPartners);
        fragmentStateAdapter.addFragment(fragService);
        fragmentStateAdapter.addFragment(fragReview);
        fragmentStateAdapter.addFragment(fragQnA);
        viewPager2.setAdapter(fragmentStateAdapter);
        viewPager2.setUserInputEnabled(false); //   스와이프로 탭 변경
    }

    private void settingTabLayout(){
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                switch(pos){
                    case 0:
                        viewPager2.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager2.setCurrentItem(1);
                        break;
                    case 2:
                        viewPager2.setCurrentItem(2);
                        break;
                    case 3:
                        viewPager2.setCurrentItem(3);
                        break;
                    case 4:
                        viewPager2.setCurrentItem(4);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });
    }
}