package com.wira_fkom.android_client;

import com.google.gson.Gson;

public class User {
    private String name;
    private String email;
    private String gambar;

    public User(String name, String email, String gambar) {
        this.name = name;
        this.email = email;
        this.gambar = gambar;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGambar() {
        return gambar;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}