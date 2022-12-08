package com.adflyercompany.recom.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.adflyercompany.recom.adapter.CustomList2ImgAdapter;
import com.adflyercompany.recom.R;

public class FragmentQnA extends Fragment {
    private ListView list;

    private String[] mainTitle ={

    };

    private String[] subTitle ={

    };

    private final Integer[] imgId={
            R.drawable.img_qna_list1,R.drawable.img_qna_list1,
            R.drawable.img_qna_list1,R.drawable.img_qna_list1,
            R.drawable.img_qna_list1,
    };

    private final Integer[] imgId2={
            R.drawable.img_qna_list2,R.drawable.img_qna_list2,
            R.drawable.img_qna_list2,R.drawable.img_qna_list2,
            R.drawable.img_qna_list2,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_qna, container, false);

        mainTitle = new String[]{
                getActivity().getString(R.string.text_qna_title1)
                ,getActivity().getString(R.string.text_qna_title2)
                ,getActivity().getString(R.string.text_qna_title3)
                ,getActivity().getString(R.string.text_qna_title4)
                ,getActivity().getString(R.string.text_qna_title5)
        };

        subTitle = new String[]{
                getActivity().getString(R.string.text_qna_subtitle1)
                ,getActivity().getString(R.string.text_qna_subtitle2)
                ,getActivity().getString(R.string.text_qna_subtitle3)
                ,getActivity().getString(R.string.text_qna_subtitle4)
                ,getActivity().getString(R.string.text_qna_subtitle5)
        };

        CustomList2ImgAdapter adapter=new CustomList2ImgAdapter(getActivity(), R.layout.custom_list_qna, mainTitle, subTitle,imgId, imgId2);
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
                }
            }
        });

        return v;
    }
}
