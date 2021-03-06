package com.htlabs.annassery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tap on 23/01/2016.
 */
public class TaxiDbAdapter {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_PIC = "pic";
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBILE = "mobile";

    private static final String TAG = "EducationDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "Annataxi";
    private static final String SQLITE_TABLE = "Taxi";
    private static final int DATABASE_VERSION = 1;

    private final Context mCtx;

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                    KEY_ROWID + " integer PRIMARY KEY autoincrement," +
                    KEY_PIC + "," +KEY_NAME + "," +
                    KEY_MOBILE + "," +
                    " UNIQUE (" + KEY_MOBILE +"));";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);
        }
    }

    public TaxiDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public TaxiDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public long createName(String pic, String name, String mobile) {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_PIC, pic);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_MOBILE, mobile);

        return mDb.insert(SQLITE_TABLE, null, initialValues);
    }

    public boolean deleteAllNames() {

        int doneDelete = 0;
        doneDelete = mDb.delete(SQLITE_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }


    public Cursor fetchAllNames() {

        Cursor mCursor = mDb.query(SQLITE_TABLE, new String[] {KEY_ROWID,
                        KEY_PIC,KEY_NAME, KEY_MOBILE},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertSomeNames() {

        createName("omni","Abc", "98283869");
        createName("tataace","abc", "99887766");
        createName("tatamagic","abc", "96576845");
    }

}