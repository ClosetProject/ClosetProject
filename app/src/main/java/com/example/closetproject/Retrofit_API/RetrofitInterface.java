package com.example.closetproject.Retrofit_API;

import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.PSizeDTO;
import com.example.closetproject.DTO.ProductDTO;
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
    Call<ArrayList<MemberDTO>> getMember(@Body ParamsVO parameter);

    // joinMember
    @POST("manipulation")
    Call<String> joinMember(@Body ParamsVO parameter);

    // Analysis Image Upload
    @Multipart
    @POST("fileUpload")
    Call<String> imageUpload(@Part("m_email") RequestBody m_email , @Part MultipartBody.Part file);

    // storeList
    @POST("query")
    Call<ArrayList<StoreDTO>> getStoreList(@Body ParamsVO parameter);

    // storeProductList
    @POST("query")
    Call<ArrayList<ProductDTO>> getProductAdapter(@Body ParamsVO parameter);

    // productDetail
    @POST("query")
    Call<ArrayList<ProductDTO>> getProduct(@Body ParamsVO parameter);

    // productDetail
    @POST("query")
    Call<ArrayList<PColorDTO>> getProductColor(@Body ParamsVO parameter);

    // productDetail
    @POST("query")
    Call<ArrayList<PSizeDTO>> getProductSize(@Body ParamsVO parameter);
}
