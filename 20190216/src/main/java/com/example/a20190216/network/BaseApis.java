package com.example.a20190216.network;


import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;


public interface BaseApis<T> {
   @POST
   Observable<ResponseBody> post(@Url String url, @QueryMap Map<String, String> map);

}
