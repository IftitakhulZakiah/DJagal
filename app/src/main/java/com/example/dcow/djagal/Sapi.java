package com.example.dcow.djagal;

import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Sapi {
    private String rfid;
    private String lokasi;
    private Date tanggal_dikirim;
    private Date tanggal_diterima;
    private Date tanggal_dipotong;
    private String status;
    private int nomor_transaksi;

    public Sapi(){

    }

    public Sapi(String rfid, String lokasi, Date tanggal_dikirim, Date tanggal_diterima,
                Date tanggal_dipotong, String status, int nomor_transaksi){
        this.rfid = rfid;
        this.lokasi = lokasi;
        this.tanggal_dikirim = tanggal_dikirim;
        this.tanggal_diterima = tanggal_diterima;
        this.tanggal_dipotong = tanggal_dipotong;
        this.status = status;
        this.nomor_transaksi = nomor_transaksi;
    }

    public String getRfid(){
        return rfid;
    }

    public void setRfid(String rfid){
        this.rfid = rfid;
    }

    public String getLokasi(){
        return lokasi;
    }

    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }

    public Date getTanggalDikirim(){
        return tanggal_dikirim;
    }

    public void setTanggalDikirim(Date tanggal_dikirim){
        this.tanggal_dikirim = tanggal_dikirim;
    }

    public Date getTanggalDiterima(){
        return tanggal_diterima;
    }

    public void setTanggalDiterima(Date tanggal_diterima){
        this.tanggal_diterima = tanggal_diterima;
    }

    public Date getTanggalDipotong(){
        return tanggal_dipotong;
    }

    public void setTanggalDipotong(Date tanggal_dipotong){
        this.tanggal_dipotong = tanggal_dipotong;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getNomorTransaksi(){
        return nomor_transaksi;
    }

    public void setNomorTransaksi(int nomor_transaksi){
        this.nomor_transaksi = nomor_transaksi;
    }
}
