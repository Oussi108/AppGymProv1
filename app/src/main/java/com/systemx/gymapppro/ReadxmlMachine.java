package com.systemx.gymapppro;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadxmlMachine {

    ArrayList<Machine> mc ;
    ReadxmlMachine(Context c){
        XmlReaderMachine(c);

    }
    public  void XmlReaderMachine( Context c)  {
        XmlPullParserFactory parseft ;

        try {
            parseft = XmlPullParserFactory.newInstance();
            XmlPullParser parse = parseft.newPullParser();
            InputStream in = c.getApplicationContext().getAssets().open("Machines.xml");

            parse.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parse.setInput(in,null);
            mc =  ParseXmlMachine(parse);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }



    }
    private ArrayList<Machine> ParseXmlMachine(XmlPullParser p){

        ArrayList<Machine> machines = null;
        try {

            int eventype = p.getEventType();


            Machine mus = null;

            while(eventype != XmlPullParser.END_DOCUMENT){

                String elmName ;

                switch (eventype){
                    case XmlPullParser.START_DOCUMENT:
                        machines=new ArrayList<>();


                        break ;
                    case XmlPullParser.START_TAG:
                        elmName = p.getName();
                        if("machine".equals(elmName))
                        {
                            mus = new Machine();
                            machines.add(mus);
                            mus.NameMachine = p.getAttributeValue(null,"name");


                        }
                        else if(mus != null)
                        {
                            if("image".equals(elmName))
                            {
                                mus.PicName = p.getAttributeValue(null,"path");
                            }
                            else if("info".equals(elmName))
                            {
                                mus.info = p.nextText();

                            }
                        }

                }





                break;

            }
            eventype = p.next();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






        return machines;


    }
}
