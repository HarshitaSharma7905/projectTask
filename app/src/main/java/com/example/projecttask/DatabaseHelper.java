package com.example.projecttask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final Integer VERSION=4;
    private static final String DATABASE_NAME="[nia]";
    private static final String TABLE_NAME="[book]";
    private static final String ID ="[id]";
    private static final String USERID="[userid]";
    private static final String URL="[url]";
    private static final String NAME="[name]";
    private static final String TYPE="[type]";
    private static final String LANGUAGE="[language]";
    private static final String STATUS="[status]";
    private static final String RUNTIME="[runtime]";
    private static final String AVERAGERUNTIME="[averageRuntime]";
    private static final String PREMIERED="[premiered]";
    private static final String DATAENDED="[dataended]";
    private static final String OFFICIALSITE ="[officialSite]";

//     DATABASE CREATION:------------------------
    private static final String sql= "CREATE TABLE" +TABLE_NAME+
        "("+ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+USERID+"TEXT,"+URL+"TEXT,"+NAME+"TEXT,"+TYPE+"TEXT,"+LANGUAGE+"TEXT,"
        +STATUS+"TEXT,"+RUNTIME+"TEXT,"+AVERAGERUNTIME+"TEXT,"+PREMIERED+"TEXT,"+DATAENDED+"TEXT,"+OFFICIALSITE+"TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
       onCreate(db);
    }
    public void addData(DataModel dataModel){
        ContentValues contentValues=new ContentValues();
        contentValues.put(USERID,dataModel.getId());
        contentValues.put(URL,dataModel.getUrl());
        contentValues.put(NAME,dataModel.getName());
        contentValues.put(TYPE,dataModel.getType());
        contentValues.put(LANGUAGE,dataModel.getLanguage());
        contentValues.put(STATUS,dataModel.getStatus());
        contentValues.put(RUNTIME,dataModel.getRuntime());
        contentValues.put(AVERAGERUNTIME,dataModel.getAverageRuntime());
        contentValues.put(PREMIERED,dataModel.getPremiered());
        contentValues.put(DATAENDED,dataModel.getEnded());
        contentValues.put(OFFICIALSITE,dataModel.getOfficialSite());
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
    }
    public DataModel fetchData(){
        String g="select * from" +TABLE_NAME;
        DataModel store=new DataModel(null,null,null,null,null,null,null,null,null,null,null);
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery(g,null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String url = cursor.getString(2);
                String name = cursor.getString(3);
                String type = cursor.getString(4);
                String language = cursor.getString(5);
                String status = cursor.getString(6);
                String runtime = cursor.getString(7);
                String averageruntime = cursor.getString(8);
                String premiered = cursor.getString(9);
                String dataended = cursor.getString(10);
                String officialsite = cursor.getString(11);
               store= new DataModel(id, url, name, type, language, status, runtime, averageruntime, premiered,
                        dataended, officialsite);
            } while (cursor.moveToNext());
        }cursor.close();
         return store;
        }
        public void deleteData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        }
        public void updateData(String id,String name,String Type,String language,String status,String runtime,
                               String average,String Premiered,String dataEnd,String official){
        ContentValues values=new ContentValues();

        values.put(NAME,name);
        values.put(TYPE,Type);
        values.put(LANGUAGE,language);
        values.put(STATUS,status);
        values.put(RUNTIME,runtime);
        values.put(AVERAGERUNTIME,average);
        values.put(PREMIERED,Premiered);
        values.put(DATAENDED,dataEnd);
        values.put(OFFICIALSITE,official);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,values,ID+"=?",new String[]{String.valueOf(id)});
        }
    }

