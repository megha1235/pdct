package com.example.megha.pdct1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="mydb.db";
    public static final String tablename="pdct";
    public static final String col1="id";
    public static final String col2="model";
    public static final String col3="code";
    public static final String col4="name";
    public static final String col5="sname";
    public static final String col6="price";
    public static final String col7="aname";
    public static final String col8="aphon";

    public dbhelper(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Querry = "create table " + tablename + "( " + col1 + " integer primary key autoincrement, " + col2 + " text, " + col3 + " text, " + col4 + " text, " + col5 + " text,  "+ col6 + " text, " + col7 + " text, " + col8 + " text)";
        sqLiteDatabase.execSQL(Querry);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String Querry = "drop table if exists " + tablename;
        sqLiteDatabase.execSQL(Querry);
        onCreate(sqLiteDatabase);

    }
    public boolean insertdata(String model,String code,String name,String sname,String price,String aname,String aphone)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,model);
        contentValues.put(col3,code);
        contentValues.put(col4,name);
        contentValues.put(col5,sname);

        contentValues.put(col6,price);

        contentValues.put(col7,aname);
        contentValues.put(col8,aphone);
        long status=sqLiteDatabase.insert(tablename,null,contentValues);
        if (status==-1)
        {
            return  false;

        }
        else
        {
            return true;
        }
    }
    public Cursor  searchdata(String model)
    {

            SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
            Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+tablename+" WHERE "+col2+"='"+model+"'",null);
            return cur;


    }
    public boolean updatedata(String id,String code,String name,String sname,String prise,String aname,String aphone) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col3, code);
        contentValues.put(col4, name);
        contentValues.put(col5, sname);
        contentValues.put(col6, prise);
        contentValues.put(col7, aname);
        contentValues.put(col8, aphone);
        long status = sqLiteDatabase.update(tablename, contentValues, col1 + "=" + id, null);
        if (status == -1)
        {
            return false;

        }
        else
        {
            return true;
        }


    }
    public  boolean dlt(String id)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long status=sqLiteDatabase.delete(tablename,col1+ "=" +id,null);
        if(status==-1)
        {
            return false;

        }
        else
        {
            return  true;
        }
    }
}
