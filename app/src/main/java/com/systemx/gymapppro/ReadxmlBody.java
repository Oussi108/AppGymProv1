package com.systemx.gymapppro;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadxmlBody {
     ArrayList<Muscle> db;

    ReadxmlBody(Context c){
        XmlReader(c);

    }



////////////////

    public  void XmlReader( Context c)  {
        XmlPullParserFactory parseft ;


        try {
            parseft = XmlPullParserFactory.newInstance();
            XmlPullParser parse = parseft.newPullParser();
            InputStream in = c.getApplicationContext().getAssets().open("Training.xml");

            parse.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parse.setInput(in,null);
            db =  ParseXml(parse);
            in.close();

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }



    }
    private ArrayList<Muscle> ParseXml(XmlPullParser p){

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
                            if("image".equals(elmName)){
                                mus.imagePath = p.getAttributeValue(null,"path");
                                p.next();
                            }else if("Muscle_part".equals(elmName)){
                                mp = new Muscle_part();
                                mus.Muscle_parts.add(mp);
                                mp.Name = p.getAttributeValue(null,"Name");


                            }else if(mp != null){
                                if ("image".equals(elmName)){
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
}
