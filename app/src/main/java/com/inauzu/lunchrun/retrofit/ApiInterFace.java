package com.inauzu.lunchrun.retrofit;

import com.inauzu.lunchrun.model.Review;
import com.inauzu.lunchrun.model.User;
import com.inauzu.lunchrun.model.testModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterFace {
    @GET("test")
    Call<testModel> getTestModel();

    @GET("test2")
    Call<testModel> getTestModel2();

    @FormUrlEncoded
    @POST("post")
    Call<testModel> postTestModel(
        @Field("alias") String alias,
        @Field("phone") String phone,
        @Field("email") String email,
        @Field("password") String password
    );

    @GET("test3")
    Call<List<Integer>> getNumbers();

    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @GET("test4")
    Call<Review> getReview(@Query("restaurant_id") Integer restaurant_id);
}
