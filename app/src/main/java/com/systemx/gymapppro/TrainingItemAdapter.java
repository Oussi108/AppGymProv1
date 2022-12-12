package com.systemx.gymapppro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public  class TrainingItemAdapter extends BaseAdapter {

    Context context;
    String[] TraningNames;
    String[] Note;
    String[] Traningsets;
    String[] Exersice;
    String[] id;
    LayoutInflater inlater;
    public TrainingItemAdapter(Context cxt,String[] tr, String[] ex ,String[] n,String[] sets,String[] ids){
        this.context = cxt;
        this.TraningNames = tr;
        this.Note =n;
        this.Traningsets= sets;
        this.Exersice = ex;
        this.id= ids;
        inlater = LayoutInflater.from(cxt);
    }
    @Override
    public int getCount() {
        return TraningNames.length;
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


        view = inlater.inflate(R.layout.activity_item_of_training_tracker,null);
        TextView tn= view.findViewById(R.id.setTrainingName);
        TextView note= view.findViewById(R.id.setNote);
        TextView ts= view.findViewById(R.id.setNumberofsets);
        TextView t= view.findViewById(R.id.setNameoftraining);
        TextView hidden= view.findViewById(R.id.hiddenID);
        hidden.setText(id[i]);
        tn.setText(TraningNames[i]);
        note.setText(Note[i]);
        ts.setText(Traningsets[i]);
        t.setText(Exersice[i]);
        Button callbtn= (Button)view.findViewById(R.id.DeleteTrain);

        callbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                Dbexercises db = new Dbexercises(v.getContext());
                db.delete(id[i]);

            }
        });



        return view;
    }
}