package com.adflyercompany.recom.fragment;

import android.content.Intent;
import android.net.Uri;
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

public class FragmentPartners extends Fragment {
    private ListView list;

    private String[] mainTitle ={
    };

    private String[] subTitle ={
    };

    private String[] siteUrl = {
    };

    private final Integer[] imgId={
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

        View v = inflater.inflate(R.layout.fragment_partners, container, false);

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

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_partners, mainTitle, subTitle,imgId);
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
}
