package com.example.closetproject.Retrofit_API;

import com.example.closetproject.DTO.BasketDTO;
import com.example.closetproject.DTO.MemberDTO;
import com.example.closetproject.DTO.MyPageDTO;
import com.example.closetproject.DTO.PColorDTO;
import com.example.closetproject.DTO.PSizeDTO;
import com.example.closetproject.DTO.ProductDTO;
import com.example.closetproject.DTO.StoreDTO;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitInterface {


    // query : select문(조회)
    // manipulation : insert(데이터삽입), update(기존 데이터 변경), delete

    // login
    @FormUrlEncoded
    @POST("login")
    Call<MemberDTO> getMember(@FieldMap HashMap<String, String> parameter);

    // joinMember
    @POST("join")
    Call<String> joinMember(@Body MemberDTO parameter);

    // Analysis Image Upload
    @Multipart
    @POST("fileUpload")
    Call<String> imageUpload(@Part("m_email") RequestBody m_email , @Part MultipartBody.Part file);

    // storeList
    @GET("store_list")
    Call<ArrayList<StoreDTO>> getStoreList();

    // storeProductList
    @FormUrlEncoded
    @POST("get_product_list")
    Call<ArrayList<ProductDTO>> getProductAdapter(@FieldMap HashMap<String, String> parameter);

    // storeProduct
    @FormUrlEncoded
    @POST("get_product")
    Call<ProductDTO> getProduct(@FieldMap HashMap<String, String> parameter);

    // Basket
    @POST("set_basket")
    Call<String> setBasket(@Body BasketDTO parameter);

    @FormUrlEncoded
    @POST("get_basket_list")
    Call<ArrayList<BasketDTO>> getBasketAdapter(@FieldMap HashMap<String, String> parameter);

    // Basket
    @POST("set_myPage")
    Call<String> setBasket(@Body MyPageDTO parameter);

    @FormUrlEncoded
    @POST("get_myPage_list")
    Call<ArrayList<MyPageDTO>> getMyPageAdater(@FieldMap HashMap<String, String> parameter);
}
