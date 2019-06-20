package com.example.alumno.myapplication.models;

public class Cliente {
    private String username;
    private String first_name;
    private String Last_name;
    private int year_old;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public int getYear_old() {
        return year_old;
    }

    public void setYear_old(int year_old) {
        this.year_old = year_old;
    }
}
