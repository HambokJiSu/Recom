package com.adflyercompany.recom.adapter;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adflyercompany.recom.R;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity  _context;
    private final String[]  _mainTitle;
    private final String[]  _subTitle;
    private final Integer[] _imgId;
    private final Integer   _layoutId;

    public CustomListAdapter(Activity context, Integer layoutId, String[] mainTitle, String[] subTitle, Integer[] imgId) {
        super(context, layoutId, mainTitle);
        // TODO Auto-generated constructor stub

        this._context   = context;
        this._layoutId  = layoutId;
        this._mainTitle = mainTitle;
        this._subTitle  = subTitle;
        this._imgId     = imgId;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=_context.getLayoutInflater();
        View rowView=inflater.inflate(_layoutId, null,true);

        TextView titleText      = (TextView)    rowView.findViewById(R.id.title);
        ImageView imageView     = (ImageView)   rowView.findViewById(R.id.icon);
        TextView subtitleText   = (TextView)    rowView.findViewById(R.id.subtitle);

        titleText.setText(_mainTitle[position]);
        imageView.setImageResource(_imgId[position]);
        subtitleText.setText(_subTitle[position]);

        return rowView;
    };

    @Override
    public int getCount(){
        return _mainTitle.length;
    }
}