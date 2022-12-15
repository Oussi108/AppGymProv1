package com.systemx.gymapppro;

import android.content.Context;

import java.util.ArrayList;

public class ExerciseType {
    public String Name;
    public String imagePath;
    public String Info;
    public int IdImage;
    public  String getImagePathName()
    {
        return imagePath != null && imagePath.lastIndexOf(".") > 0 ? imagePath.substring(0, imagePath.lastIndexOf(".")) : imagePath;
    }
    public int  getimageid (Context c){

        int p;

            if(imagePath != null){
                 p =  c.getResources().getIdentifier(getImagePathName(),"drawable",c.getPackageName());
                 if(p == 0)
                     p = R.drawable.null_image;
            }
            else
                p = R.drawable.null_image;


        return p;
    }
}
