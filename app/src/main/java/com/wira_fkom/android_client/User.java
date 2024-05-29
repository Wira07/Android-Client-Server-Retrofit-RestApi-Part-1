package com.wira_fkom.android_client;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("gambar")
    private String gambar;

    // Konstruktor untuk membuat objek User baru dengan id
    public User(int id, String name, String email, String gambar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gambar = gambar;
    }

    // Konstruktor untuk membuat objek User tanpa id (misalnya, untuk menambahkan user baru)
    public User(String name, String email, String gambar) {
        this.name = name;
        this.email = email;
        this.gambar = gambar;
    }

    // Getter dan Setter untuk id user
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter dan Setter untuk nama user
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter untuk email user
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter dan Setter untuk gambar user
    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    // Override toString untuk mengonversi objek User ke JSON
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
