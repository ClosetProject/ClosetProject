package com.example.closetproject.Retrofit_API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// SingleTon Pattern
// 사용법
// getInstance()로 retrofit 빌드
// getRetrofitAPI를 사용
public class RetrofitClient {

    private static RetrofitClient instance = null;
    private static RetrofitInterface retrofitAPI;

    private final static String baseURL = "http://121.147.185.76:8081/";

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitAPI = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitInterface getRetrofitAPI(){
        return retrofitAPI;
    }

}
