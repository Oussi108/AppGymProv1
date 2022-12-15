package com.systemx.gymapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_muscle extends AppCompatActivity {

    ListView lsm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);
        lsm= findViewById(R.id.ListVM);

        ReadxmlBody dba = new ReadxmlBody(getApplicationContext());
        String tit,info;
        int imageid ;
        muscle_adapter mia;


        Bundle extras = getIntent().getExtras();
        int Value;
        int Value2;
        if (extras != null) {
            String v = extras.getString("ItemPostion");
            String v1 = extras.getString("muscle");
            //The key argument here must match that used in the other activity
            Value = Integer.valueOf(v);
            Value2 = Integer.valueOf(v1);
        }
        else {
            Value = -1;
            Value2 =-1;
        }
        if(Value == -1 || Value2 == -1 ){
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
            ArrayList<Integer> ee = new ArrayList<>();
            ee.add(R.drawable.null_image);
            mia = new muscle_adapter(getApplicationContext(),ee);
        }
        else {
            mia = new muscle_adapter
                    (getApplicationContext(),
                            dba.db.get(Value2).Muscle_parts.get(Value).getIdImagelistmuscle_parts(getApplicationContext()));

        }
        lsm.setAdapter(mia);
        lsm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(activity_muscle.this,Display_Training_activity.class);
                in.putExtra("lastPostion",String.valueOf(i));
                in.putExtra("secondpostion",String.valueOf(Value));
                in.putExtra("firstpostion",String.valueOf(Value2));
                startActivity(in);
            }
        });
    }
}