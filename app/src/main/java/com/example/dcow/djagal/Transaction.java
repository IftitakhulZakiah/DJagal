package com.example.dcow.djagal;

/**
 * Created by adyan on 2/23/2018.
 */

import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Transaction {
    private String id_object;
    private String name;
    private String from;
    private String to;
    private String status;
    private int total_cow;
    private String date;

    public Transaction() {

    }

    public Transaction(String id_object, String name, String from, String to, String status,
                       int total_cow, String date) {
        this.id_object = id_object;
        this.name = name;
        this.from = from;
        this.to = to;
        this.status = status;
        this.total_cow = total_cow;
        this.date = date;
    }

    public String getIdObject() {
        return id_object;
    }

    public void setIdObject(String id_object) {
        this.id_object = id_object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTotalCow() {
        return total_cow;
    }

    public void setTotalCow(int total_cow) {
        this.total_cow = total_cow;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

