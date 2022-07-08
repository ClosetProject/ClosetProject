package com.example.closetproject.Retrofit_API;

import com.example.closetproject.DTO.MemberDTO;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    // login
    @POST("query")
    Call<MemberDTO> getMember(@Body ParamsVO parameter);

    // joinMember
    @POST("manipulation")
    Call<String> joinMember(@Body ParamsVO parameter);

}
