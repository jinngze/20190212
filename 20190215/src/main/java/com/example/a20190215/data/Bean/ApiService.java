package com.example.a20190215.data.Bean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

   @GET("videoCategory")
    Call<ResponseBody> getResponseData();

   @GET("videoCategoryDetails?id=14")
    Call<ResponseBody> getResponseGood();

   @GET("small/commodity/v1/commodityList")
    Call<ResponseBody> getRequestData();
}
