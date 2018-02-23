package com.example.dcow.djagal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.DateFormat;
import android.util.Log;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adyan on 2/23/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "djagalManager";

    // Table Names
    private static final String TABLE_TRANSACTION = "transactions";
    private static final String TABLE_SAPI = "cows";
    private static final String TABLE_CHAT = "chats";
    // private static final String TABLE_USER = "users";

    // Common names
    private static final String KEY_STATUS = "status";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_FROM = "origin";
    private static final String KEY_DATE = "date";

    // TRANSACTION Table - column names
    private static final String KEY_TRANSACTION = "id_object";
    private static final String KEY_NAME = "name";
    private static final String KEY_TO = "destination";
    private static final String KEY_TOTAL_COW = "total_cow";

    // SAPI Table - column names
    private static final String KEY_RFID = "rfid";
    private static final String KEY_ID_TRANSACTION = "id_transaction";
    private static final String KEY_SEND_DATE = "send_date";
    private static final String KEY_RECEIVED_DATE = "received_date";
    private static final String KEY_DEAD_DATE = "dead_date";    

    // CHATS Table - column names
    private static final String KEY_MESSAGE = "message";

    // Table Create Statements
    // Transaction table create statement
    
    private static final String CREATE_TABLE_TRANSACTION = "CREATE TABLE " + TABLE_TRANSACTION + " (" +
    KEY_TRANSACTION + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_FROM + " TEXT," + 
    KEY_TO + " TEXT," + KEY_STATUS + " TEXT," + KEY_TOTAL_COW + " INTEGER," +
    KEY_DATE + " TEXT)";

    // Sapi table create statement
    private static final String CREATE_TABLE_SAPI = "CREATE TABLE " + TABLE_SAPI
            + "(" + KEY_RFID + " TEXT PRIMARY KEY," + KEY_ID_TRANSACTION + " TEXT,"
            + KEY_LOCATION + " TEXT," + KEY_SEND_DATE + " TEXT," + KEY_RECEIVED_DATE + " TEXT," 
            + KEY_DEAD_DATE + " TEXT," +  KEY_STATUS + " TEXT" + ")";

    // Chat table create statement
    private static final String CREATE_TABLE_CHAT = "CREATE TABLE "
            + TABLE_CHAT + "(" + KEY_FROM + " TEXT,"
            + KEY_MESSAGE + " TEXT," + KEY_DATE + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_TRANSACTION);
        db.execSQL(CREATE_TABLE_SAPI);
        db.execSQL(CREATE_TABLE_CHAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(LOG, "onUpgrade");
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAPI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHAT);

        // create new tables
        onCreate(db);
    }
    
    /*
    * Creating a transaction
    */
    public long createTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
    
        ContentValues values = new ContentValues();
        values.put(KEY_TRANSACTION, transaction.getIdObject());
        values.put(KEY_NAME, transaction.getName());
        values.put(KEY_FROM, transaction.getFrom());
        values.put(KEY_TO, transaction.getTo());
        values.put(KEY_STATUS, transaction.getStatus());
        values.put(KEY_TOTAL_COW, transaction.getTotalCow());
        values.put(KEY_DATE, transaction.getDate());
    
        // insert row
        long rowId = db.insertWithOnConflict(TABLE_TRANSACTION, null, values, SQLiteDatabase.CONFLICT_REPLACE);

    
        return rowId;
    }

    /*
 * get single todo
 */
    public Transaction getTransaction(String id_object) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TRANSACTION + " WHERE "
                + KEY_TRANSACTION + " = " + id_object;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Transaction tr = new Transaction();
        tr.setIdObject(c.getString(c.getColumnIndex(KEY_TRANSACTION)));
        tr.setName(c.getString(c.getColumnIndex((KEY_NAME))));
        tr.setFrom(c.getString(c.getColumnIndex(KEY_FROM)));
        tr.setTo(c.getString(c.getColumnIndex(KEY_TO)));
        tr.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));
        tr.setTotalCow(c.getInt(c.getColumnIndex(KEY_TOTAL_COW)));
        tr.setDate(c.getString(c.getColumnIndex(KEY_DATE)));

        return tr;
    }

    /*
    * getting all transaction
    * */

    public List<Transaction> getAllTransactions() throws ParseException {
        List<Transaction> transactions = new ArrayList<Transaction>();
        String selectQuery = "SELECT  * FROM " + TABLE_TRANSACTION;
    
        Log.e(LOG, selectQuery);
    
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
    
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Transaction tr = new Transaction();
                tr.setIdObject(c.getString(c.getColumnIndex(KEY_TRANSACTION)));
                tr.setName(c.getString(c.getColumnIndex((KEY_NAME))));
                tr.setFrom(c.getString(c.getColumnIndex(KEY_FROM)));
                tr.setTo(c.getString(c.getColumnIndex(KEY_TO)));
                tr.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));
                tr.setTotalCow(c.getInt(c.getColumnIndex(KEY_TOTAL_COW)));
                tr.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
    
                // adding to Transaction list
                transactions.add(tr);
            } while (c.moveToNext());
        }
    
        return transactions;
    }

    /*
    * Updating a Transaction
    */
    public int updateTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
    
        ContentValues values = new ContentValues();
        values.put(KEY_TRANSACTION, transaction.getIdObject());
        values.put(KEY_NAME, transaction.getName());
        values.put(KEY_FROM, transaction.getFrom());
        values.put(KEY_TO, transaction.getTo());
        values.put(KEY_STATUS, transaction.getStatus());
        values.put(KEY_TOTAL_COW, transaction.getTotalCow());
        values.put(KEY_DATE, transaction.getDate());
    
        // updating row
        return db.update(TABLE_TRANSACTION, values, KEY_TRANSACTION + " = ?",
                new String[] { String.valueOf(transaction.getIdObject()) });
    }

    public long createSapi(Sapi sapi) {
        SQLiteDatabase db = this.getWritableDatabase();
    
        ContentValues values = new ContentValues();
        values.put(KEY_RFID, sapi.getRfid());
        values.put(KEY_ID_TRANSACTION, sapi.getIdTransaksi());
        values.put(KEY_LOCATION, sapi.getLocation());
        values.put(KEY_SEND_DATE, sapi.getSendDate());
        values.put(KEY_RECEIVED_DATE, sapi.getReceivedDate());
        values.put(KEY_DEAD_DATE, sapi.getDeadDate());
        values.put(KEY_STATUS, sapi.getStatus());
    
        // insert row
        long rowId = db.insertWithOnConflict(TABLE_SAPI, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    
        return rowId;
    }

    public Sapi getSapi(String rfid) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SAPI + " WHERE "
                + KEY_RFID + " = " + rfid;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Sapi sp = new Sapi();
        sp.setRfid(c.getString(c.getColumnIndex(KEY_RFID)));
        sp.setIdTransaksi(c.getString(c.getColumnIndex((KEY_ID_TRANSACTION))));
        sp.setLocation(c.getString(c.getColumnIndex(KEY_LOCATION)));
        sp.setSendDate(c.getString(c.getColumnIndex(KEY_SEND_DATE)));
        sp.setReceivedDate(c.getString(c.getColumnIndex(KEY_RECEIVED_DATE)));
        sp.setDeadDate(c.getString(c.getColumnIndex(KEY_DEAD_DATE)));
        sp.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));

        return sp;
    }

    public List<Sapi> getAllSapi() {
        List<Sapi> cows = new ArrayList<Sapi>();
        String selectQuery = "SELECT  * FROM " + TABLE_SAPI;
    
        Log.e(LOG, selectQuery);
    
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
    
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Sapi sp = new Sapi();
                sp.setRfid(c.getString(c.getColumnIndex(KEY_RFID)));
                sp.setIdTransaksi(c.getString(c.getColumnIndex((KEY_ID_TRANSACTION))));
                sp.setLocation(c.getString(c.getColumnIndex(KEY_LOCATION)));
                sp.setSendDate(c.getString(c.getColumnIndex(KEY_SEND_DATE)));
                sp.setReceivedDate(c.getString(c.getColumnIndex(KEY_RECEIVED_DATE)));
                sp.setDeadDate(c.getString(c.getColumnIndex(KEY_DEAD_DATE)));
                sp.setStatus(c.getString(c.getColumnIndex(KEY_STATUS)));
    
                // adding to sapi list
                cows.add(sp);
            } while (c.moveToNext());
        }
    
        return cows;
    }

    public int updateSapi(Sapi sapi) {
        SQLiteDatabase db = this.getWritableDatabase();
    
        ContentValues values = new ContentValues();
        values.put(KEY_RFID, sapi.getRfid());
        values.put(KEY_ID_TRANSACTION, sapi.getIdTransaksi());
        values.put(KEY_LOCATION, sapi.getLocation());
        values.put(KEY_SEND_DATE, sapi.getSendDate());
        values.put(KEY_RECEIVED_DATE, sapi.getReceivedDate());
        values.put(KEY_DEAD_DATE, sapi.getDeadDate());
        values.put(KEY_STATUS, sapi.getStatus());
    
        // updating row
        return db.update(TABLE_SAPI, values, KEY_RFID + " = ?",
                new String[] { String.valueOf(sapi.getRfid()) });
    }

}
