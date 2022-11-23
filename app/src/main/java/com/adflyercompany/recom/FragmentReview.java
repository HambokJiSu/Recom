package com.adflyercompany.recom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentReview extends Fragment {
    private ListView list;

    private final String[] maintitle ={
            "GoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGoodGood"
            ,"NiceNiceNiceNiceNiceNiceNiceNiceNiceNiceNiceNiceNiceNice"
            ,"SosoSosoSosoSosoSosoSosoSosoSosoSosoSosoSosoSosoSosoSosoSoso"
            ,"Not badNot badNot badNot badNot badNot badNot badNot badNot bad"
            ,"No comment",
    };

    private final String[] subtitle ={
            "Da-on/Seoul"
            ,"Su-ho/Suji"
            ,"Meerket/Zoo"
            ,"Raccon/Zoo"
            ,"Ji-ho/Suji"
    };

    private final Integer[] imgid={
            R.drawable.img_review_list1,R.drawable.img_review_list2,
            R.drawable.img_review_list3,R.drawable.img_review_list4,
            R.drawable.img_review_list5,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_review, container, false);

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_review, maintitle, subtitle,imgid);
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
}
