package com.systemx.gymapppro;

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

}