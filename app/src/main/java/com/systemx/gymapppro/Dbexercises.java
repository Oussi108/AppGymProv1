package com.systemx.gymapppro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbexercises extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Exersice.db";
    private static final String TABLE_Exercise = "Exercise";
    private static final String KEY_ID = "id";
    private static final String KEY_Train_NAME = "Custom_Name";
    private static final String KEY_NAME_Ex = "Exersice_Name";
    private static final String KEY_Note = "Note";
    private static final String KEY_Sets = "Sets";
    public Dbexercises(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_Exercise + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_Train_NAME + " TEXT,"
                + KEY_NAME_Ex + " TEXT,"
                + KEY_Note + " TEXT ,"
                + KEY_Sets + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Exercise);

        // Create tables again
        onCreate(db);

    }
    void addTrain(Custom_Train Train) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Train_NAME, Train.getCustom_Name());
        values.put(KEY_NAME_Ex, Train.getExersice_Name());
        values.put(KEY_Note, Train.getNote());
        values.put(KEY_Sets, Train.getSets());

        // Inserting Row
        db.insert(TABLE_Exercise, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    //get one id
    Custom_Train getTrain(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Exercise, new String[] { KEY_ID,
                        KEY_Train_NAME, KEY_NAME_Ex, KEY_Note,KEY_Sets}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Custom_Train Train = new Custom_Train(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4));
        // return Train
        return Train;
    }
    public List<Custom_Train> getAllTrains() {
        List<Custom_Train> TrainList = new ArrayList<Custom_Train>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Exercise;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Custom_Train tr = new Custom_Train();
                tr.set_id(Integer.parseInt(cursor.getString(0)));
                tr.setCustom_Name(cursor.getString(1));
                tr.setExersice_Name(cursor.getString(2));
                tr.setNote(cursor.getString(3));
                tr.setSets(cursor.getString(4));
                // Adding Trains to list
                TrainList.add(tr);
            } while (cursor.moveToNext());
        }

        // return Trains list
        return TrainList;
    }
    // code to update the single row
    public int updateTrain(Custom_Train Train) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_Train_NAME, Train.getCustom_Name());
        values.put(KEY_NAME_Ex, Train.getExersice_Name());
        values.put(KEY_Note, Train.getNote());
        values.put(KEY_Sets, Train.getSets());
        // updating row
        return db.update(TABLE_Exercise, values, KEY_ID + " = ?",
                new String[] { String.valueOf(Train.get_id()) });
    }
    // Deleting single contact
    public void deleteTrain(Custom_Train Train) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Exercise, KEY_ID + " = ?",
                new String[] { String.valueOf(Train.get_id()) });
        db.close();
    }
    // Getting Trains Count
    public int getTrainsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_Exercise;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public void delete(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from "+TABLE_Exercise+" where id='"+id+"'");
    }
}
