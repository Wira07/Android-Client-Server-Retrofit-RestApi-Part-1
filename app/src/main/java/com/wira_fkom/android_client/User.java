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
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("telepon")
    private String telepon;

    // Konstruktor untuk membuat objek User baru dengan id
    public User(int id, String name, String email, String gambar, String alamat, String telepon) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gambar = gambar;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    // Konstruktor untuk membuat objek User tanpa id (misalnya, untuk menambahkan user baru)
    public User(String name, String email, String gambar, String alamat, String telepon) {
        this.name = name;
        this.email = email;
        this.gambar = gambar;
        this.alamat = alamat;
        this.telepon = telepon;
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

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

//    public void setGambar(String gambar) {
//        this.gambar = gambar;
//    }

    // Override toString untuk mengonversi objek User ke JSON
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

//public class User {
//    private int id;
//    private String name;
//    private String email;
//    private String gambar;
//    private String alamat;
//    private String telepon;
//
//    public User(int id, String name, String email, String gambar, String alamat, String telepon) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.gambar = gambar;
//        this.alamat = alamat;
//        this.telepon = telepon;
//    }
//
//    public User(String name, String email, String gambar, String alamat, String telepon) {
//        this.name = name;
//        this.email = email;
//        this.gambar = gambar;
//        this.alamat = alamat;
//        this.telepon = telepon;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getGambar() {
//        return gambar;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public String getTelepon() {
//        return telepon;
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//                "\"name\":\"" + name + "\"," +
//                "\"email\":\"" + email + "\"," +
//                "\"gambar\":\"" + gambar + "\"," +
//                "\"alamat\":\"" + alamat + "\"," +
//                "\"telepon\":\"" + telepon + "\"" +
//                "}";
//    }
//}
