package com.systemx.gymapppro;

import java.util.ArrayList;

public class Muscle {
    public int IdImage;
    public String Name;
    public String imagePath;
    public ArrayList<Muscle_part> Muscle_parts =new ArrayList<Muscle_part>() ;

    public  String getImagePathName()
    {
        return imagePath != null && imagePath.lastIndexOf(".") > 0 ? imagePath.substring(0, imagePath.lastIndexOf(".")) : imagePath;
    }
}
