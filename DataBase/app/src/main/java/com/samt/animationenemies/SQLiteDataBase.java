package com.samt.animationenemies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataBase extends SQLiteOpenHelper {
    SQLiteDatabase db;

    //DATABASE NAME
    private static final String DATABASE_NAME="Student_info";

    //DATABASE VERSION
    private static final int DATABASE_VERSION=1;

    //DATABASE TABLE NAME
    private static final String TABLE_STUDENT="thistudent";

    //DATABASE TABLE COLUMNS
    private static final String KEY_ROWID="id";
    private static final String KEY_FIRST_NAME="firstname";
    private static final String KEY_LAST_NAME="lastname";

    public SQLiteDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_STUDENT_TABLE="CREATE TABLE " +TABLE_STUDENT+ "(" +KEY_ROWID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_FIRST_NAME+ " TEXT, " +KEY_LAST_NAME+ " TEXT);";
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);
        onCreate(sqLiteDatabase);
    }

    public long insertStudent(String firstname, String lastname) {
        db=this.getWritableDatabase();
        //Content value used to insert data in database table
        ContentValues cv=new ContentValues();
        cv.put(KEY_FIRST_NAME,firstname);
        cv.put(KEY_LAST_NAME,lastname);
        return db.insert(TABLE_STUDENT,null,cv);
    }

    public String getData() {
        db=this.getReadableDatabase();
        //Cursor class is used for to access specific table in database
        String[] columns=new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_LAST_NAME};
        Cursor c=db.query(TABLE_STUDENT,columns,null,null,null,null,null);
        String result="";
        int iRow=c.getColumnIndex(KEY_ROWID);
        int iFirstname=c.getColumnIndex(KEY_FIRST_NAME);
        int iLastname=c.getColumnIndex(KEY_LAST_NAME);
        for(c.moveToFirst(); !c.isAfterLast();c.moveToNext())
        {
            result=result + c.getString(iRow)+ "" +c.getString(iFirstname)+ "" +c.getString(iLastname)+ "\n";
        }
        db.close();
        return result;
    }

    public String getstudentlastname(long l) {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_LAST_NAME};
        Cursor c=db.query(TABLE_STUDENT,columns,KEY_ROWID+ "=" +l   ,null,null,null,null);
        if(c != null)
        {
            c.moveToFirst();
            String name=c.getString(1);
            return name;
        }
        return null;
    }

    public String getstudentfirstname(long l) {
        db=this.getReadableDatabase();
        String[] columns=new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_LAST_NAME};
        Cursor c=db.query(TABLE_STUDENT,columns,KEY_ROWID+ "=" +l   ,null,null,null,null);
        if(c != null)
        {
            c.moveToFirst();
            String name=c.getString(2);
            return name;
        }
        return null;
    }

    public void UpdateStudent(long l, String firstname, String lastname) {
        db=this.getWritableDatabase();
        //Content value used to insert data in database table
        ContentValues cv=new ContentValues();
        cv.put(KEY_FIRST_NAME,firstname);
        cv.put(KEY_LAST_NAME,lastname);
        db.update(TABLE_STUDENT,cv, KEY_ROWID+ "=" +l,null);
        db.close();

    }

    public void deletestudentname(long l) {
        db=this.getWritableDatabase();
        db.delete(TABLE_STUDENT,KEY_ROWID + "=" +l, null);
    }
}
