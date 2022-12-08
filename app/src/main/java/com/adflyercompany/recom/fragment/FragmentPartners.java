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

public class FragmentPartners extends Fragment {
    private ListView list;

    private String[] mainTitle ={
    };

    private String[] subTitle ={
    };

    private final Integer[] imgId={
            R.drawable.img_partner_list11
            ,R.drawable.img_partner_list12
            ,R.drawable.img_partner_list13
            ,R.drawable.img_partner_list14
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_partners, container, false);

        mainTitle = new String[] {
                 getString(R.string.text_partner_title1)
                ,getString(R.string.text_partner_title2)
                ,getString(R.string.text_partner_title3)
                ,getString(R.string.text_partner_title4)
        };

        subTitle = new String[] {
                getString(R.string.text_partner_subtitle1)
                ,getString(R.string.text_partner_subtitle2)
                ,getString(R.string.text_partner_subtitle3)
                ,getString(R.string.text_partner_subtitle4)
        };

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_partners, mainTitle, subTitle,imgId);
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
