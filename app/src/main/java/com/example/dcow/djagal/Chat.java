package com.example.dcow.djagal;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by adyan on 2/23/2018.
 */

public class Chat {
    private String from;
    private String message;
    private long date;


    public Chat(){

    }

    public Chat(String from, String message){
        this.from = from;
        this.message = message;
        this.date = new Date().getTime();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
