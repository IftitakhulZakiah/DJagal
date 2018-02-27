package com.example.dcow.djagal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by adyan on 2/23/2018.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {
    private List<Transaction> transactionsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, date;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.titleTransaksi);
            date = (TextView) view.findViewById(R.id.dateTransaksi);
        }
    }


    public TransactionAdapter(List<Transaction> transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Transaction transaction = transactionsList.get(position);
        holder.name.setText("Transaksi " + transaction.getName());
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        holder.date.setText(df.format(transaction.getDate()));
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }
}
