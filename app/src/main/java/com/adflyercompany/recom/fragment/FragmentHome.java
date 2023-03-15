package com.adflyercompany.recom.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.adflyercompany.recom.adapter.CustomListAdapter;
import com.adflyercompany.recom.adapter.ImageSliderAdapter;
import com.adflyercompany.recom.R;
import com.adflyercompany.recom.animation.ZoomOutPageTransformer;

public class FragmentHome extends Fragment {
    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;
    private ListView list;

    //  Online 이미지 로딩시 사용
//    private String[] images = new String[] {
//            "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg",
//            "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg",
//            "https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg",
//            "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg",
//            "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg"
//    };

    private final Integer[] images = new Integer[] {
            R.drawable.img_home21,
            R.drawable.img_home12,
            R.drawable.img_home23
    };

    private String[] mainTitle ={
    };

    private String[] subTitle ={
    };

    private String[] siteUrl = {
    };

    private final Integer[] imgid={
            R.drawable.img_partner_list1
            ,R.drawable.img_partner_list2
            ,R.drawable.img_partner_list3
            ,R.drawable.img_partner_list4
            ,R.drawable.img_partner_list5
            ,R.drawable.img_partner_list6
            ,R.drawable.img_partner_list7
            ,R.drawable.img_partner_list8
            ,R.drawable.img_partner_list9
            ,R.drawable.img_partner_list10
            ,R.drawable.img_partner_list11
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mainTitle = new String[] {
                getString(R.string.text_partner_title1)
                ,getString(R.string.text_partner_title2)
                ,getString(R.string.text_partner_title3)
                ,getString(R.string.text_partner_title4)
                ,getString(R.string.text_partner_title5)
                ,getString(R.string.text_partner_title6)
                ,getString(R.string.text_partner_title7)
                ,getString(R.string.text_partner_title8)
                ,getString(R.string.text_partner_title9)
                ,getString(R.string.text_partner_title10)
                ,getString(R.string.text_partner_title11)
        };

        subTitle = new String[] {
                getString(R.string.text_partner_subtitle1)
                ,getString(R.string.text_partner_subtitle2)
                ,getString(R.string.text_partner_subtitle3)
                ,getString(R.string.text_partner_subtitle4)
                ,getString(R.string.text_partner_subtitle5)
                ,getString(R.string.text_partner_subtitle6)
                ,getString(R.string.text_partner_subtitle7)
                ,getString(R.string.text_partner_subtitle8)
                ,getString(R.string.text_partner_subtitle9)
                ,getString(R.string.text_partner_subtitle10)
                ,getString(R.string.text_partner_subtitle11)

        };

        siteUrl = new String[] {
                getString(R.string.text_partner_url1)
                ,getString(R.string.text_partner_url2)
                ,getString(R.string.text_partner_url3)
                ,getString(R.string.text_partner_url4)
                ,getString(R.string.text_partner_url5)
                ,getString(R.string.text_partner_url6)
                ,getString(R.string.text_partner_url7)
                ,getString(R.string.text_partner_url8)
                ,getString(R.string.text_partner_url9)
                ,getString(R.string.text_partner_url10)
                ,getString(R.string.text_partner_url11)
        };

        sliderViewPager = v.findViewById(R.id.sliderViewPager);
        layoutIndicator = v.findViewById(R.id.layoutIndicators);

        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(getActivity(), images));
        sliderViewPager.setPageTransformer(new ZoomOutPageTransformer());

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_home, mainTitle, subTitle,imgid);
        list = (ListView)v.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(siteUrl[position]));
                getActivity().startActivity(intent);
            }
        });

        return v;
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(),
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getActivity(),
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getActivity(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}
