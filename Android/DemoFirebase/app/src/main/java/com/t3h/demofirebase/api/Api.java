package com.t3h.demofirebase.api;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("fcm/send")
    Call<ResponseBody> sendFCM(@Body JSONObject body);
}
