package com.systemx.gymapppro;

public class Custom_Train {

    int _id;
    String Custom_Name;
    String Exersice_Name;
    String Note;
    String Sets;
    public Custom_Train(){   }
    public Custom_Train(int id, String _Custom_Name, String _Exersice_Name, String _Note, String _Sets){
        this._id = id;
        this.Custom_Name = _Custom_Name;
        this.Exersice_Name = _Exersice_Name;
        this.Note = _Note;
        this.Sets = _Sets;
    }
    public Custom_Train(String _Custom_Name, String _Exersice_Name, String _Note, String _Sets){

        this.Custom_Name = _Custom_Name;
        this.Exersice_Name = _Exersice_Name;
        this.Note = _Note;
        this.Sets = _Sets;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCustom_Name() {
        return Custom_Name;
    }

    public void setCustom_Name(String custom_Name) {
        Custom_Name = custom_Name;
    }

    public String getExersice_Name() {
        return Exersice_Name;
    }

    public void setExersice_Name(String exersice_Name) {
        Exersice_Name = exersice_Name;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String _Note) {
        Note = _Note;
    }

    public String getSets() {
        return Sets;
    }

    public void setSets(String sets) {
        Sets = sets;
    }





}

