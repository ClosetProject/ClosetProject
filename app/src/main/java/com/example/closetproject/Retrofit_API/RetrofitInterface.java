package com.example.closetproject.Retrofit_API;

import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.DTO.StoreDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitInterface {


    // query : select문(조회)
    // manipulation : insert(데이터삽입), update(기존 데이터 변경), delete

    // login
    @POST("query")
    Call<MemberDTO> getMember(@Body ParamsVO parameter);

    // joinMember
    @POST("manipulation")
    Call<String> joinMember(@Body ParamsVO parameter);

    // Analysis Image Upload
    @Multipart
    @POST("fileUpload")
    Call<String> imageUpload(@Part("m_email") RequestBody m_email , @Part MultipartBody.Part file);

    // storeList
    @POST("query")
    Call<ArrayList<StoreDTO>> storeList(@Body ParamsVO parameter);
}
