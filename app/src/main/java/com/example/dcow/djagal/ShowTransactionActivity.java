package com.example.dcow.djagal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.List;

public class ShowTransactionActivity extends AppCompatActivity {

    private TextView titleView;
    private TextView fromView;
    private TextView toView;
    private TextView dateView;
    private TextView totalCowView;
    private TextView statusView;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String id_object =
                intent.getStringExtra("com.example.dcow.djagal.extra.idtransaksi");

        db = new DatabaseHelper(this);
        Transaction tr = new Transaction();
        try {
            List<Transaction> trs = db.getAllTransactions();
            if(trs.size() > 0){
                for (int i = 0; i < trs.size(); i++){
                    if(id_object.equals(trs.get(i).getIdObject())){
                        tr = trs.get(i);
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        titleView = (TextView) findViewById(R.id.name);
        fromView = (TextView) findViewById(R.id.from);
        toView = (TextView) findViewById(R.id.to);
        dateView = (TextView) findViewById(R.id.date);
        totalCowView = (TextView) findViewById(R.id.total_cow);
        statusView = (TextView) findViewById(R.id.status);
        titleView.setText(tr.getName());
        fromView.setText("Origin: " + tr.getFrom());
        toView.setText("Destination: " + tr.getTo());
        dateView.setText("Date: " + tr.getDate());
        totalCowView.setText("Total cow: " + Integer.toString(tr.getTotalCow()));
        statusView.setText("Status: " + tr.getStatus());
    }

}
