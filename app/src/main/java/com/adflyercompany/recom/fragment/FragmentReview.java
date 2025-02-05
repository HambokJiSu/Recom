package com.adflyercompany.recom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.adflyercompany.recom.adapter.CustomListAdapter;
import com.adflyercompany.recom.R;

public class FragmentReview extends Fragment {
    private ListView list;

    private String[] mainTitle;

    private final String[] subTitle ={
            "Adela/Nova Scotia"
            ,"Bruno/Delaware"
            ,"Joanna/Kentucky"
            ,"Leo/New York"
    };

    private final Integer[] imgId={
            R.drawable.img_review_list11,R.drawable.img_review_list12,
            R.drawable.img_review_list13,R.drawable.img_review_list14
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_review, container, false);

        mainTitle = new String[]{
                getActivity().getString(R.string.text_review_title1)
                , getActivity().getString(R.string.text_review_title2)
                , getActivity().getString(R.string.text_review_title3)
                , getActivity().getString(R.string.text_review_title4)
        };

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_review, mainTitle, subTitle,imgId);
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
                }
            }
        });

        return v;
    }
}
