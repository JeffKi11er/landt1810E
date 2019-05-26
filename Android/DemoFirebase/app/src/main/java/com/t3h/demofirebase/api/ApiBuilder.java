package com.t3h.demofirebase.api;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    private static Api api;

    public static Api getApi(){
        if (api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://fcm.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHeader())
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }

    public static OkHttpClient getHeader(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder b = chain.request().newBuilder();
                b.addHeader("Content-Type", "application/json");
                b.addHeader("Authorization", "key=AIzaSyBApda3T0NxA_X4tJhMEut_L5ehxFKCG8s");
                return chain.proceed(b.build());
            }
        });
        return builder.build();
    }
}
