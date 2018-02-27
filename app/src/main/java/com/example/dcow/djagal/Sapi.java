package com.example.dcow.djagal;

import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Sapi {
    private String id_transaksi;
    private String rfid;
    private String location;
    private Date send_date;
    private Date received_date;
    private Date dead_date;
    private String status;
    

    public Sapi(){

    }

    public Sapi(String id_transaksi, String rfid, String location, Date send_date, Date received_date,
                Date dead_date, String status){
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

    public Date getSendDate(){
        return send_date;
    }

    public void setSendDate(Date send_date){
        this.send_date = send_date;
    }

    public Date getReceivedDate(){
        return received_date;
    }

    public void setReceivedDate(Date received_date){
        this.received_date = received_date;
    }

    public Date getDeadDate(){
        return dead_date;
    }

    public void setDeadDate(Date dead_date){
        this.dead_date = dead_date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
