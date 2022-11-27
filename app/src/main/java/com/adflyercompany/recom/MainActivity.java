package com.adflyercompany.recom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.adflyercompany.recom.animation.DepthPageTransformer;
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

    private TextView txtRestaurant;
    private TextView txtFitNCare;

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

        txtRestaurant = findViewById(R.id.txtRestaurant);
        txtFitNCare = findViewById(R.id.txtFitNCare);

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

    public void onLogoClick(View view){
        viewPager2.setCurrentItem(0);
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
    }

    private void settingTabLayout(){
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

        });
    }

    // 플로팅 액션 버튼 클릭시 애니메이션 효과
    public void toggleFab() {
        if(fabMain_status) {
            txtRestaurant.setText(R.string.EMPTY);
            txtFitNCare.setText(R.string.EMPTY);
            // 플로팅 액션 버튼 닫기
            // 애니메이션 추가
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabRestaurant, "translationY", 0f);
            fc_animation.start();
            ObjectAnimator ft1_animation1 = ObjectAnimator.ofFloat(txtRestaurant, "translationX", 0f);
            ObjectAnimator ft1_animation2 = ObjectAnimator.ofFloat(txtRestaurant, "translationY", 0f);
            ft1_animation1.start();
            ft1_animation2.start();
            ObjectAnimator fe_animation = ObjectAnimator.ofFloat(fabFitNCare, "translationY", 0f);
            fe_animation.start();
            ObjectAnimator ft2_animation1 = ObjectAnimator.ofFloat(txtFitNCare, "translationX", 0f);
            ObjectAnimator ft2_animation2 = ObjectAnimator.ofFloat(txtFitNCare, "translationY", 0f);
            ft2_animation1.start();
            ft2_animation2.start();

            // 메인 플로팅 이미지 변경
            fabMain.setImageResource(android.R.drawable.ic_input_add);

        }else {
            txtRestaurant.setText(R.string.fab_restaurant);
            txtFitNCare.setText(R.string.fab_fitncare);
            // 플로팅 액션 버튼 열기
            ObjectAnimator fc_animation = ObjectAnimator.ofFloat(fabRestaurant, "translationY", -400f);
            fc_animation.start();
            ObjectAnimator ft1_animation1 = ObjectAnimator.ofFloat(txtRestaurant, "translationX", -200f);
            ObjectAnimator ft1_animation2 = ObjectAnimator.ofFloat(txtRestaurant, "translationY", -400f);
            ft1_animation1.start();
            ft1_animation2.start();
            ObjectAnimator fe_animation = ObjectAnimator.ofFloat(fabFitNCare, "translationY", -200f);
            fe_animation.start();
            ObjectAnimator ft2_animation1 = ObjectAnimator.ofFloat(txtFitNCare, "translationX", -200f);
            ObjectAnimator ft2_animation2 = ObjectAnimator.ofFloat(txtFitNCare, "translationY", -200f);
            ft2_animation1.start();
            ft2_animation2.start();
            // 메인 플로팅 이미지 변경
            fabMain.setImageResource(android.R.drawable.ic_delete);
        }
        // 플로팅 버튼 상태 변경
        fabMain_status = !fabMain_status;
    }
}