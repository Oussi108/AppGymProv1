package com.systemx.gymapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.util.ArrayList;

public class GetTrackerPage extends AppCompatActivity {

    EditText Name ;
    EditText note;
    EditText sets;
    Button valid ;
    Button Cancel ;
    Spinner Ex ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tracker_page);
        Dbexercises db = new Dbexercises(this);
        Name = (EditText)findViewById(R.id.CustomName);

        note = (EditText)findViewById(R.id.Note);
        sets = (EditText)findViewById(R.id.Numbersets);
        valid = (Button)findViewById(R.id.AddTrain);
        Cancel = (Button)findViewById(R.id.CancelTrain);
        Ex = (Spinner) findViewById(R.id.spinner_ExerciseName);
        ////////////////////
        ReadxmlBody rd = new ReadxmlBody(this);
        ArrayList<String> musc = new ArrayList<>();

        for (Muscle m:rd.db) {
            for (Muscle_part d:m.Muscle_parts) {
                for (ExerciseType e:d.Exercises) {
                    musc.add(e.Name.replace("_"," "));

                }

            }

        }




        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,musc);
        ad.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        Ex.setAdapter(ad);
        ////
        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name,ex,n,set;
                name = String.valueOf(Name.getText());
                ex = String.valueOf(Ex.getSelectedItem().toString());
                n = String.valueOf(note.getText());
                set = String.valueOf(sets.getText());

                Custom_Train tr = new Custom_Train(name,ex,n,set);
                db.addTrain(tr);


            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}