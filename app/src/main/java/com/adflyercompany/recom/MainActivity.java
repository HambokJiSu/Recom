package com.adflyercompany.recom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.adflyercompany.recom.adapter.FragmentStateAdapter;
import com.adflyercompany.recom.animation.DepthPageTransformer;
import com.adflyercompany.recom.fragment.FragmentHome;
import com.adflyercompany.recom.fragment.FragmentPartners;
import com.adflyercompany.recom.fragment.FragmentQnA;
import com.adflyercompany.recom.fragment.FragmentRecomFitNCare;
import com.adflyercompany.recom.fragment.FragmentRecomResturant;
import com.adflyercompany.recom.fragment.FragmentReview;
import com.adflyercompany.recom.fragment.FragmentService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FragmentStateAdapter fragmentStateAdapter;

    private FragmentHome fragHome;
    private FragmentPartners fragPartners;
    private FragmentService fragService;
    private FragmentReview fragReview;
    private FragmentQnA fragQnA;

    private FragmentRecomResturant fragRecomResturant;
    private FragmentRecomFitNCare fragRecomFitNCare;

    private TabLayout tabLayout;

    private boolean fabMain_status;

    private FloatingActionButton fabMain;
    private FloatingActionButton fabRestaurant;
    private FloatingActionButton fabFitNCare;


    private TextView txtWelcome;


    private ImageView imgLogIn;
    private ImageView imgLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFragment();

        createViewpager();

        settingTabLayout();

        fabMain = findViewById(R.id.fabMain);
        fabRestaurant = findViewById(R.id.fabRestaurant);
        fabFitNCare = findViewById(R.id.fabFitNCare);

        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        imgLogIn = (ImageView) findViewById(R.id.imageLogIn);
        imgLogOut = (ImageView) findViewById(R.id.imageLogOut);

        // 메인플로팅 버튼 클릭
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFab();

            }
        });
        // 레스토랑 플로팅 버튼 클릭
        fabRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Get 버튼 클릭", Toast.LENGTH_SHORT).show();
                viewPager2.setCurrentItem(5, false);
            }
        });

        // 피트니스 n 케어 플로팅 버튼 클릭
        fabFitNCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Delete 버튼 클릭", Toast.LENGTH_SHORT).show();
                viewPager2.setCurrentItem(6, false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();

        if ("S".equals(intent.getStringExtra("login"))) {
            txtWelcome.setVisibility(View.VISIBLE);
            imgLogIn.setVisibility(View.INVISIBLE);
            imgLogOut.setVisibility(View.VISIBLE);
        }
        else {
            txtWelcome.setVisibility(View.INVISIBLE);
            imgLogIn.setVisibility(View.VISIBLE);
            imgLogOut.setVisibility(View.INVISIBLE);
        }
    }

    public void onLogoClick(View view){
        viewPager2.setCurrentItem(0, false);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onLogoutClick(View view){
        txtWelcome.setVisibility(View.INVISIBLE);
        imgLogIn.setVisibility(View.VISIBLE);
        imgLogOut.setVisibility(View.INVISIBLE);
    }

    public void onRestaurantClick(View view){
        viewPager2.setCurrentItem(5, false);
    }

    public void onFitNCareClick(View view){
        viewPager2.setCurrentItem(6, false);
    }

    private void createFragment(){
        fragHome = new FragmentHome();
        fragPartners = new FragmentPartners();
        fragService = new FragmentService();
        fragReview = new FragmentReview();
        fragQnA = new FragmentQnA();
        fragRecomResturant = new FragmentRecomResturant();
        fragRecomFitNCare = new FragmentRecomFitNCare();
    }

    private void createViewpager(){
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        fragmentStateAdapter = new FragmentStateAdapter(getSupportFragmentManager(), getLifecycle());
        fragmentStateAdapter.addFragment(fragHome);
        fragmentStateAdapter.addFragment(fragPartners);
        fragmentStateAdapter.addFragment(fragService);
        fragmentStateAdapter.addFragment(fragReview);
        fragmentStateAdapter.addFragment(fragQnA);
        fragmentStateAdapter.addFragment(fragRecomResturant);
        fragmentStateAdapter.addFragment(fragRecomFitNCare);
        viewPager2.setAdapter(fragmentStateAdapter);
        viewPager2.setPageTransformer(new DepthPageTransformer());
        viewPager2.setUserInputEnabled(false); //   스와이프로 탭 변경
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (position == 5 || position == 6)
                    tabLayout.setScrollPosition(0, 1, true);
            }
        });
    }

    private void settingTabLayout(){
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition() + 1);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition() + 1);
            }

        });
    }

    // 플로팅 액션 버튼 클릭시 애니메이션 효과
    public void toggleFab() {
        if(fabMain_status) {    // 플로팅 액션 버튼 닫기
            // 애니메이션 추가
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabRestaurant, "translationY", 0f);
            fc_animation.start();
            ObjectAnimator fe_animation = ObjectAnimator.ofFloat(fabFitNCare, "translationY", 0f);
            fe_animation.start();
            // 메인 플로팅 이미지 변경
            fabMain.setImageResource(android.R.drawable.ic_input_add);

        }else {                 // 플로팅 액션 버튼 열기
            // 애니메이션 추가
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabRestaurant, "translationY", -340f);
            fc_animation.start();
            ObjectAnimator fe_animation = ObjectAnimator.ofFloat(fabFitNCare, "translationY", -170f);
            fe_animation.start();
            // 메인 플로팅 이미지 변경
            fabMain.setImageResource(android.R.drawable.ic_delete);
        }
        // 플로팅 버튼 상태 변경
        fabMain_status = !fabMain_status;
    }
}