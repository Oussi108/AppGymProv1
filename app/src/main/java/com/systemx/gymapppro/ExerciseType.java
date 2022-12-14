package com.systemx.gymapppro;

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
}
