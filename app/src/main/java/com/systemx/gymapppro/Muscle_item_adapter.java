package com.systemx.gymapppro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class Muscle_item_adapter extends BaseAdapter {
    LayoutInflater inlflater;
    Context cnt ;
    ArrayList<Integer> images;
    Muscle_item_adapter(Context c ,ArrayList<Integer> i ){
        this.cnt = c;
        this.images = i;
        this.inlflater = LayoutInflater.from(c);


    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inlflater.inflate(R.layout.muscle_part_item,null);
        ImageView D = view.findViewById(R.id.muscle_part_image);
        D.setBackground(view.getResources().getDrawable(images.get(i),null));

        return view;
    }
}
