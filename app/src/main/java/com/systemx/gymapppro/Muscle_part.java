package com.systemx.gymapppro;

import android.content.Context;

import java.util.ArrayList;

public class Muscle_part {
    public String Name;
    public String imagePath;
    public ArrayList<ExerciseType> Exercises = new ArrayList<ExerciseType>() ;
    public int IdImage;
    public  String getImagePathName()
    {
        return imagePath != null && imagePath.lastIndexOf(".") > 0 ? imagePath.substring(0, imagePath.lastIndexOf(".")) : imagePath;
    }
    public ArrayList<Integer> getIdImagelistmuscle_parts(Context c){

        ArrayList<Integer> d =new ArrayList<>() ;
        for (ExerciseType a:Exercises) {
            if(a.imagePath != null){
                int p =  c.getResources().getIdentifier(a.getImagePathName(),"drawable",c.getPackageName());
                if (p != 0 ){
                    d.add(p);
                }else {

                    d.add(c.getResources().getIdentifier("null_image","drawable",c.getPackageName()));
                }
            }

        }
        return d;
    }
}