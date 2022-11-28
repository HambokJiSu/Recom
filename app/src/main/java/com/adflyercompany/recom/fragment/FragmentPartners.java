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
            R.drawable.img_partners_list1,R.drawable.img_partners_list2,
            R.drawable.img_partners_list3,R.drawable.img_partners_list4,
            R.drawable.img_partners_list5,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_partners, container, false);

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), R.layout.custom_list_partners, maintitle, subtitle,imgid);
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
