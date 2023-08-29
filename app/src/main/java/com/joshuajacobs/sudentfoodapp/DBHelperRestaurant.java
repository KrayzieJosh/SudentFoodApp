package com.joshuajacobs.sudentfoodapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelperRestaurant
        extends SQLiteOpenHelper {


    private static String DB_PATH = "";
    private static String DB_NAME = "db2.db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private SQLiteOpenHelper sqLiteOpenHelper;


    public static final String
            RESTAURANTS
            = "Restaurants";


    public DBHelperRestaurant(Context context)
    {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = myContext.getDatabasePath(DB_NAME)
                .toString();
    }


    public void createDataBase()
            throws IOException
    {

        boolean dbExist = checkDataBase();

        if (dbExist) {
        }
        else {

            this.getWritableDatabase();
            try {
                copyDataBase();
            }
            catch (IOException e) {
                throw new Error(
                        "Error copying database");
            }
        }
    }

    private boolean checkDataBase()
    {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH;
            checkDB
                    = SQLiteDatabase
                    .openDatabase(
                            myPath, null,
                            SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e) {

            Log.e("message", "" + e);
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }


    private void copyDataBase()
            throws IOException
    {
        InputStream myInput
                = myContext.getAssets()
                .open(DB_NAME);

        String outFileName = DB_PATH;

        OutputStream myOutput
                = new FileOutputStream(outFileName);


        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }


        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase()
            throws SQLException
    {

        String myPath = DB_PATH;
        myDataBase = SQLiteDatabase
                .openDatabase(
                        myPath, null,
                        SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close()
    {

        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion)
    {

    }


    public List<String> getAlgorithmTopics(
            Activity activity)
    {
        sqLiteOpenHelper
                = new DBHelperRestaurant(activity);
        SQLiteDatabase db
                = sqLiteOpenHelper
                .getWritableDatabase();

        List<String> list
                = new ArrayList<>();

        String query = "SELECT restaurantName || ' ' || restaurantPhoneNumber AS combinedInfo FROM " + RESTAURANTS;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            list.add(cursor.getString(0)); // Combined restaurantName and phoneNumber
        }
        cursor.close();
        return list;

    }

}