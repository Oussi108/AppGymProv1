package com.systemx.gymapppro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SetAlarmActivity extends AppCompatActivity {

    EditText message ;
    EditText hour;
    EditText min;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);
        message = findViewById(R.id.custom_message);
        hour = findViewById(R.id.txthour);
        min = findViewById(R.id.txtmin);


        btn =findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hours ,mins;
                hours = Integer.valueOf(String.valueOf(hour.getText()));
                mins = Integer.valueOf(String.valueOf(min.getText()));
                Toast.makeText(getApplicationContext(),hours+" "+mins,Toast.LENGTH_LONG).show();
                if (hours < 24 && mins < 60 && hours >= 8 && mins >= 0 ){

                    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                    i.putExtra(AlarmClock.EXTRA_MESSAGE, " newasdss");
                    i.putExtra(AlarmClock.EXTRA_HOUR, hours);
                i.putExtra(AlarmClock.EXTRA_MINUTES, mins);
                startActivity(i);
                }else
                    Toast.makeText(getApplicationContext(),"time is not correct",Toast.LENGTH_LONG).show();

            }
        });




    }
}