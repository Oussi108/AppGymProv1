package com.systemx.gymapppro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class TrackerFragment extends Fragment {


    ListView ls ;




    Button btnN ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_tracker, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
        ls = view.findViewById(R.id.ListViewTracker);
        Dbexercises db = new Dbexercises(getActivity());
        List<Custom_Train> ct = new ArrayList<>();
        ct = db.getAllTrains();
        String[] t= new String[ct.size()];
        String[] t1= new String[ct.size()];
        String[] t2= new String[ct.size()];
        String[] t3= new String[ct.size()];
        String[] t4= new String[ct.size()];
        for(int i = 0;i < ct.size();i++ ){

            t[i] = ct.get(i).getCustom_Name();
            t1[i] = ct.get(i).getExersice_Name();
            t2[i] = ct.get(i).getNote();
            t3[i] = ct.get(i).getSets();
            t4[i] = String.valueOf(ct.get(i).get_id());
        }



        TrainingItemAdapter fr = new TrainingItemAdapter(view.getContext(),t,t1,t2,t3,t4);
        ls.setAdapter(fr);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


        btnN = view.findViewById(R.id.AddTracker);
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),GetTrackerPage.class));
            }
        });
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
                Log.i("Hello!", "Y u no see me?");
                Toast.makeText(view.getContext(),t[position],Toast.LENGTH_LONG).show();


        }

    });
        }


}