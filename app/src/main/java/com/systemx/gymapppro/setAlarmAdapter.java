package com.systemx.gymapppro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class setAlarmAdapter extends BaseAdapter {
    Context cnt;
    ArrayList<String> names ;
    ArrayList<Integer> picsID;
    LayoutInflater inflater;

    public setAlarmAdapter(Context cn, ArrayList<String> names, ArrayList<Integer> picsID) {
        this.cnt = cn;
        this.names = names;
        this.picsID = picsID;
        inflater = LayoutInflater.from(cn);
    }

    @Override
    public int getCount() {
        return names.size();
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
        view = inflater.inflate(R.layout.activity_set_alarm_item,null);
        TextView t = view.findViewById(R.id.Testy);
        t.setText(names.get(i));


        return view;
    }
}
