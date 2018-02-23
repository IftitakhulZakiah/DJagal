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
    private String penjual;
    private String pembeli;
    private String status;
    private int jumlah_sapi;
    private Date tanggal;

    public Transaction() {

    }

    public Transaction(int nomor, String penjual, String pembeli, String status,
                       int jumlah_sapi, Date tanggal) {
        this.nomor = nomor;
        this.penjual = penjual;
        this.pembeli = pembeli;
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

    public String getPenjual() {
        return penjual;
    }

    public void setPenjual(String penjual) {
        this.penjual = penjual;
    }

    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
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

