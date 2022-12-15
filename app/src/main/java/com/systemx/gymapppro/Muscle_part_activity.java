package com.systemx.gymapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Muscle_part_activity extends AppCompatActivity {

    ListView ls ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_part);
        Bundle extras = getIntent().getExtras();

        int Value;
        if (extras != null) {
             String v = extras.getString("ItemPostion");
            //The key argument here must match that used in the other activity
            Value = Integer.valueOf(v);
        }
        else {
            Value = -1;
        }
        ls = findViewById(R.id.ListVMP);
        ReadxmlBody d = new ReadxmlBody(getApplicationContext());
        ArrayList<Integer> inte =new ArrayList<>();
        inte.add(R.drawable.null_image);
        muscle_adapter ma;
        if(Value != -1){
            ma = new muscle_adapter(getApplicationContext(),d.db.get(Value).getIdImagelistmuscles(getApplicationContext()));
        }else
        {
            ma = new muscle_adapter(getApplicationContext(),inte);
            Toast.makeText(getApplicationContext(),"Error happened " ,Toast.LENGTH_LONG).show();
        }
        ls.setAdapter(ma);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(Muscle_part_activity.this,activity_muscle.class);
                in.putExtra("ItemPostion",String.valueOf(i));
                in.putExtra("muscle",String.valueOf(Value));
                startActivity(in);
            }
        });

    }
}