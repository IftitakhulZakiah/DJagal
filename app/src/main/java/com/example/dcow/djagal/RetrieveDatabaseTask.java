package com.example.dcow.djagal;

import android.content.Context;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class RetrieveDatabaseTask extends AsyncTask<String, Void, String> {
    private final Context mContext;

    public RetrieveDatabaseTask(Context context) {
        super();
        this.mContext = context;
    }

    protected String doInBackground(String... urls) {
        String result = null;
        try {
            String urlRequest = "http://188.166.241.234:8080/" + "transaction";
            URL url = new URL(urlRequest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String temp;
            while((temp = br.readLine()) != null){
                sb.append(temp);
            }
            result = sb.toString();
            Log.d("Data Init", result);
        } catch (IOException | ParseException ex){
            ex.printStackTrace();
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onPostExecute(String result) {
        DatabaseHelper db = new DatabaseHelper(mContext);
        try {
            JSONObject data = new JSONObject(result);
            if (data.getBoolean("success")){
                JSONArray transactions = data.getJSONArray("result");
                Log.d("RETRIEVE_TRANSACTION", transactions.toString());
                for (int i = 0; i < transactions.length(); i++) {
                    JSONObject tr = transactions.getJSONObject(i);
                    String id_object = tr.getString("_id");
                    String name = tr.getString("name");
                    String from = tr.getString("from");
                    String to = tr.getString("to");
                    String status = tr.getString("status");
                    int total_cow = tr.getInt("totalCow");
                    String date = tr.getString("date");
                    db.createTransaction(new Transaction(id_object, name, from, to, status, total_cow, date));
                    JSONArray sapis = tr.getJSONArray("sapi");
                    for(int j = 0; j < sapis.length(); j++){
                        JSONObject sp = sapis.getJSONObject(j);
                        String rfid = sp.getString("rfid");
                        String location = sp.getString("location");
                        String send_date = sp.getString("sendDate");
                        String received_date = sp.getString("receivedDate");
                        String dead_date = sp.getString("deadDate");
                        String statusSp = sp.getString("status");
                        db.createSapi(new Sapi(id_object, rfid, location, send_date, received_date,
                                dead_date, statusSp));
                    }
                }
            }
            else {
                Log.d("RETRIEVE_TRANSACTION", data.getString("message"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
