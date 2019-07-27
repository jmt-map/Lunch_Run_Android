package com.inauzu.lunchrun.retrofit;

import com.inauzu.lunchrun.model.testModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterFace {
    @GET("test")
    Call<testModel> getTestModel();

    @GET("test2")
    Call<testModel> getTestModel2();

    @FormUrlEncoded
    @POST("test3")
    Call<testModel> postTestModel(
        @Field("id") int id
    );
}
