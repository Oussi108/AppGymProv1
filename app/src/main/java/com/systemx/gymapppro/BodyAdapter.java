package com.systemx.gymapppro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class BodyAdapter extends BaseAdapter {
      ArrayList<Integer> idpic;
    private  Context ctx;
    private LayoutInflater inf ;
    @Override
    public int getCount() {
        return idpic.size();
    }
    public BodyAdapter(Context cn, ArrayList<Integer> Idpic){
        this.idpic =Idpic;
        this.ctx = cn;
        this.inf = LayoutInflater.from(cn);
    }

    @Override
    public Object getItem(int i) {
        return idpic.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inf.inflate(R.layout.activity_body_item,null);
        ImageView ib = view.findViewById(R.id.Bodyimagebutton);
        ib.setBackground(view.getResources().getDrawable(idpic.get(i),null));


        return view;
    }
}
