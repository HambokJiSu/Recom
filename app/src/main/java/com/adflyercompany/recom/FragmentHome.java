package com.adflyercompany.recom;

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
            R.drawable.img_home1,
            R.drawable.img_home2,
            R.drawable.img_home3
    };

    private final String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    private final String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };

    private final Integer[] imgid={
            R.drawable.img_home_list1,R.drawable.img_home_list2,
            R.drawable.img_home_list1,R.drawable.img_home_list1,
            R.drawable.img_home_list2,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        sliderViewPager = v.findViewById(R.id.sliderViewPager);
        layoutIndicator = v.findViewById(R.id.layoutIndicators);

        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(getActivity(), images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_home, maintitle, subtitle,imgid);
        list = (ListView)v.findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    // Todo
                }else if(position == 1) {
                    // Todo
                }else if(position == 2) {
                    // Todo
                }else if(position == 3) {
                    // Todo
                }else if(position == 4) {
                    // Todo
                }

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
