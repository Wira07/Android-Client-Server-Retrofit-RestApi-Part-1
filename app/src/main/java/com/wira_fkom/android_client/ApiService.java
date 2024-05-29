package com.wira_fkom.android_client;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {
    @POST("insert_user.php")
    Call<Void> insertUser(@Body User user);

    @GET("get_user.php")
    Call<List<User>> getUsers();

    @PUT("update_user.php")
    Call<Void> updateUser(@Body User user);

    @Multipart
    @POST("insert_user.php")
    Call<Void> uploadImage(@Part MultipartBody.Part image, @Part("user") RequestBody user);

    @DELETE("delete_user.php/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
