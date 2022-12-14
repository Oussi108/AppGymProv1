package com.systemx.gymapppro;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BodyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BodyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BodyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BodyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BodyFragment newInstance(String param1, String param2) {
        BodyFragment fragment = new BodyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body, container, false);
    }

    ListView LS ;
    ArrayList<Muscle> db ;
    TextView tv ;


    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        LS = view.findViewById(R.id.ListviewBody);
        XmlReader(view);
        ArrayList<Integer> d =new ArrayList<>() ;
        for (Muscle a:db) {
            if(a.imagePath != null){
               int p =  getResources().getIdentifier(a.getImagePathName(),"drawable",getActivity().getPackageName());
            if (p!= 0){
                d.add(p);
            }
            }

        }





        tv = view.findViewById(R.id.testet);


        tv.setText(String.valueOf(db.get(0).Muscle_parts.get(0).Exercises.get(0).imagePath));
        BodyAdapter ba = new BodyAdapter(view.getContext(),d);
        LS.setAdapter(ba);



    }


    ////////////
    public void XmlReader(View v)  {
        XmlPullParserFactory parseft ;

        try {
            parseft = XmlPullParserFactory.newInstance();
            XmlPullParser parse = parseft.newPullParser();
            InputStream in = getActivity().getApplicationContext().getAssets().open("Training.xml");
            if(in == null){
                Toast.makeText(v.getContext(),"null",Toast.LENGTH_LONG).show();

            }
            parse.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parse.setInput(in,null);
            db =  ParseXml(parse,v);
            in.close();

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }



    }
    private ArrayList<Muscle> ParseXml(XmlPullParser p,View v){

        ArrayList<Muscle> Muscles = null;
        try {

            int eventype = p.getEventType();


            Muscle mus = null;
            Muscle_part mp = null;
            ExerciseType et = null;
            while(eventype != XmlPullParser.END_DOCUMENT){

            String elmName ;

            switch (eventype){
                case XmlPullParser.START_DOCUMENT:
                    Muscles=new ArrayList<>();


                    break ;
                case XmlPullParser.START_TAG:
                    elmName = p.getName();
                    if("Muscle".equals(elmName)){
                        mus = new Muscle();
                        Muscles.add(mus);
                        mus.Name = p.getAttributeValue(null,"name");


                    }else if(mus != null){
                        if("image_Muscle".equals(elmName)){
                            mus.imagePath = p.getAttributeValue(null,"path");

                        }else if("Muscle_part".equals(elmName)){
                             mp = new Muscle_part();
                             mus.Muscle_parts.add(mp);
                            mp.Name = p.getAttributeValue(null,"Name");


                        }else if(mp != null){
                            if ("imagep".equals(elmName)){
                               mp.imagePath = p.getAttributeValue(null,"path");


                            }
                            else if("ExerciseType".equals(elmName)){
                                et = new ExerciseType();
                                mp.Exercises.add(et);
                                et.Name = p.getAttributeValue(null,"name");


                            } else if(et != null){
                                if("image".equals(elmName)){
                                et.imagePath = p.getAttributeValue(null,"path");
                                }
                                else if("info".equals(elmName)){
                                    et.Info = p.nextText();


                                }
                            }

                        }




                    }
                    break;

            }
            eventype = p.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Muscles;
    }

    ///////////
}