package com.adflyercompany.recom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentQnA extends Fragment {
    private ListView list;

    private final String[] maintitle ={
            "This is my first visit to Korea.\nCan I move with a guide?"
            ,"Are group tour possible?"
            ,"Many android applications use text view for displaying text within android applications."
            ,"In this article, we will take a look at How to center align TextView Horizontally and Vertically in the android applications. "
            ,"No question",
    };

    private final String[] subtitle ={
            "Welcome to Korea for.."
            ,"Yes.\nPlease contact the manager."
            ,"TextView widget in Android using Java with Examples"
            ,"How to add fading TextView animation in Android"
            ,"No Answer"
    };

    private final Integer[] imgid={
            R.drawable.img_qna_list1,R.drawable.img_qna_list1,
            R.drawable.img_qna_list1,R.drawable.img_qna_list1,
            R.drawable.img_qna_list1,
    };

    private final Integer[] imgid2={
            R.drawable.img_qna_list2,R.drawable.img_qna_list2,
            R.drawable.img_qna_list2,R.drawable.img_qna_list2,
            R.drawable.img_qna_list2,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_qna, container, false);

        CustomList2ImgAdapter adapter=new CustomList2ImgAdapter(getActivity(), R.layout.custom_list_qna, maintitle, subtitle,imgid, imgid2);
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
