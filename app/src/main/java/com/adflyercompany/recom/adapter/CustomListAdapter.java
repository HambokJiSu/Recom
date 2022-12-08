package com.adflyercompany.recom.adapter;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adflyercompany.recom.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;

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
        titleText.setText(_mainTitle[position]);

        TextView subtitleText   = (TextView)    rowView.findViewById(R.id.subtitle);
        subtitleText.setText(_subTitle[position]);

        ShapeableImageView simageView;
        ImageView imageView;

        if (_layoutId == R.layout.custom_list_partners) {
            simageView = (ShapeableImageView) rowView.findViewById(R.id.icon);
            simageView.setShapeAppearanceModel(simageView.getShapeAppearanceModel()
                    .toBuilder()
                    .setTopRightCorner(CornerFamily.ROUNDED, 50)
                    .setTopLeftCorner(CornerFamily.ROUNDED, 50)
                    .build());
            simageView.setImageResource(_imgId[position]);
        }
        else {
            imageView = (ImageView) rowView.findViewById(R.id.icon);
            imageView.setImageResource(_imgId[position]);
        }

        return rowView;
    };

    @Override
    public int getCount(){
        return _mainTitle.length;
    }
}