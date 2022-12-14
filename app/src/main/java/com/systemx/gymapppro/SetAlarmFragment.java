package com.systemx.gymapppro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SetAlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetAlarmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SetAlarmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MachineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetAlarmFragment newInstance(String param1, String param2) {
        SetAlarmFragment fragment = new SetAlarmFragment();
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
    ListView LS ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_alarm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LS = view.findViewById(R.id.ListVmachines);
        Dbexercises db = new Dbexercises(view.getContext());
        ArrayList<String> d = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        for (Custom_Train  q :db.getAllTrains()) {
            d.add(q.Custom_Name);
            c.add(0);

        }
        setAlarmAdapter ma = new setAlarmAdapter(view.getContext(),d,c);



        LS.setAdapter(ma);
        LS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent inten = new Intent(getActivity(),SetAlarmActivity.class);
                startActivity(inten);
            }
        });

    }
    /*
    public  ArrayList<Machine> XmlReaderMachine(View v)  {
        XmlPullParserFactory parseft ;
        ArrayList<Machine> mc = null ;
        AssetManager assetManager = getActivity().getAssets();
        try {
            InputStream xmlStream = assetManager.open("Machines.xml");


            parseft = XmlPullParserFactory.newInstance();
            XmlPullParser parse = parseft.newPullParser();


            if(xmlStream == null){
                Toast.makeText(v.getContext(),xmlStream.toString(),Toast.LENGTH_LONG).show();

            }
            parseft.setNamespaceAware(true);

            parse.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parse.setInput(xmlStream,"UTF-8");
            mc =  ParseXmlMachine(parse,v);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
        return mc;


    }
    private ArrayList<Machine> ParseXmlMachine(XmlPullParser p,View v){

        ArrayList<Machine> machines = null;
        try {

            int eventype = p.getEventType();


            Machine mus = null;

            while(eventype != XmlPullParser.END_DOCUMENT){

                String elmName ;

                switch (eventype){
                    case XmlPullParser.START_DOCUMENT:
                        machines = new ArrayList<>();

                        Toast.makeText(v.getContext(),String.valueOf(p.getName()),Toast.LENGTH_LONG).show();
                        elmName = p.getName();

                        if("machine".equals(elmName))
                        {
                            Toast.makeText(v.getContext(),"strat",Toast.LENGTH_LONG).show();

                            mus = new Machine();
                            machines.add(mus);
                            mus.NameMachine = p.getAttributeValue(null,"name");
                            p.next();


                        }
                        else if(mus != null)
                        {
                            if("image".equals(elmName))
                            {
                                mus.PicName = p.getAttributeValue(null,"path");
                                p.next();
                            }
                            else if("info".equals(elmName))
                            {
                                mus.info = p.nextText();

                            }
                        }

                }
                        break ;

            }
            eventype = p.next();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






        return machines;


    }
*/
}