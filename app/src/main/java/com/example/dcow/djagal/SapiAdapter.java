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

public class SapiAdapter extends RecyclerView.Adapter<SapiAdapter.MyViewHolder> {
    private List<Sapi> sapiList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView rfid, location, status;

        public MyViewHolder(View view) {
            super(view);
            rfid = (TextView) view.findViewById(R.id.rfidSapi);
            location = (TextView) view.findViewById(R.id.lokasiSapi);
            status = (TextView) view.findViewById(R.id.statusSapi);
        }
    }


    public SapiAdapter(List<Sapi> sapiList) {
        this.sapiList = sapiList;
    }

    @Override
    public SapiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_list_row, parent, false);

        return new SapiAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SapiAdapter.MyViewHolder holder, int position) {
        Sapi sapi = sapiList.get(position);
        holder.rfid.setText(sapi.getRfid());
        holder.location.setText(sapi.getLocation());
        holder.status.setText(sapi.getStatus());
    }

    @Override
    public int getItemCount() {
        return sapiList.size();
    }
}
