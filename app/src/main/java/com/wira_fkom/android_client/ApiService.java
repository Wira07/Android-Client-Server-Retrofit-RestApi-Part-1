package com.wira_fkom.android_client;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @POST("insert_user.php")
    Call<Void> insertUser(@Body User user);

    @GET("get_user.php")
    Call<List<User>> getUsers();

    @Multipart
    @POST("insert_user.php")
    Call<Void> uploadImage(@Part MultipartBody.Part image, @Part("user") RequestBody user);
}
