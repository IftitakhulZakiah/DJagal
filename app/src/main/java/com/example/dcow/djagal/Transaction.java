package com.example.dcow.djagal;

/**
 * Created by adyan on 2/23/2018.
 */

import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Transaction {
    private int nomor;
    private String from;
    private String to;
    private String status;
    private int jumlah_sapi;
    private Date tanggal;

    public Transaction() {

    }

    public Transaction(int nomor, String from, String to, String status,
                       int jumlah_sapi, Date tanggal) {
        this.nomor = nomor;
        this.from = from;
        this.to = to;
        this.status = status;
        this.jumlah_sapi = jumlah_sapi;
        this.tanggal = tanggal;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getJumlahSapi() {
        return jumlah_sapi;
    }

    public void setJumlahSapi(int jumlah_sapi) {
        this.jumlah_sapi = jumlah_sapi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}

