package com.example.dcow.djagal;

import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Sapi {
    private String id_transaksi;
    private String rfid;
    private String location;
    private String send_date;
    private String received_date;
    private String dead_date;
    private String status;
    

    public Sapi(){

    }

    public Sapi(String id_transaksi, String rfid, String location, String send_date, String received_date,
                String dead_date, String status){
        this.id_transaksi = id_transaksi;
        this.rfid = rfid;
        this.location = location;
        this.send_date = send_date;
        this.received_date = received_date;
        this.dead_date = dead_date;
        this.status = status;
    }

    public String getIdTransaksi(){
        return id_transaksi;
    }

    public void setIdTransaksi(String id_transaksi){
        this.id_transaksi = id_transaksi;
    }

    public String getRfid(){
        return rfid;
    }

    public void setRfid(String rfid){
        this.rfid = rfid;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getSendDate(){
        return send_date;
    }

    public void setSendDate(String send_date){
        this.send_date = send_date;
    }

    public String getReceivedDate(){
        return received_date;
    }

    public void setReceivedDate(String received_date){
        this.received_date = received_date;
    }

    public String getDeadDate(){
        return dead_date;
    }

    public void setDeadDate(String dead_date){
        this.dead_date = dead_date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
