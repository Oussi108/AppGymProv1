package com.systemx.gymapppro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class Display_Training_activity extends AppCompatActivity {

    ImageView vi ;
    TextView tv ;
    TextView Title ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_training);
        vi = findViewById(R.id.displayimage);
        tv= findViewById(R.id.displayinfo);
        Title = findViewById(R.id.displaytitle);
        tv.setMovementMethod(new ScrollingMovementMethod());


        ReadxmlBody dba = new ReadxmlBody(getApplicationContext());
        String tit,info;
        int imageid ;

        Bundle extras = getIntent().getExtras();
        int Valueindx;
        int Valueindx2;
        int Valueindx3;
        if (extras != null) {
            String v = extras.getString("firstpostion");
            String v1 = extras.getString("secondpostion");
            String v2 = extras.getString("lastPostion");
            //The key argument here must match that used in the other activity
            Valueindx = Integer.valueOf(v);
            Valueindx2 = Integer.valueOf(v1);
            Valueindx3 = Integer.valueOf(v2);
        }
        else {
            Valueindx = -1;
            Valueindx2 =-1;
            Valueindx3 = -1;
        }
        if(Valueindx == -1 || Valueindx2 == -1 || Valueindx3 ==-1 ){
            vi.setBackground(getDrawable(R.drawable.null_image));
            tv.setText("error");
            Title.setText("error");
        }
        else {
            tit = dba.db.get(Valueindx).Muscle_parts.get(Valueindx2).Exercises.get(Valueindx3).Name;
            info =dba.db.get(Valueindx).Muscle_parts.get(Valueindx2).Exercises.get(Valueindx3).Info;
            imageid = dba.db.get(Valueindx).Muscle_parts.get(Valueindx2).Exercises.get(Valueindx3).getimageid(getApplicationContext());

            vi.setBackground(getDrawable(imageid));
            tv.setText(info);
            Title.setText(tit.replace("_"," "));
        }

    }
}