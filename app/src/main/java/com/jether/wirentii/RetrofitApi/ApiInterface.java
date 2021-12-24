package com.jether.wirentii.RetrofitApi;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/registration.php")
    Call<Users> performRegistration(
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Password") String user_pass,
            @Query("UserType") int user_type
    );

    @GET("api/upDatePassword.php")
    Call<Users> updatePassword(
            @Query("ID") String user_id,
            @Query("Password") String user_pass

    );


    @GET("api/updateUser.php")
    Call<Users> updateUser(
            @Query("ID") String user_id,
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Aboutme") String user_about

    );

    @GET("api/login.php")
    Call<Users> performLogin(
            @Query("Email") String user_email,
            @Query("Password") String user_pass

    );

    @POST("api/loadrequestInfo.php")
    Call<Users>requestKulaba(
            @Field("FullName") String user_name,
            @Field("Email") String user_email,
            @Field("MobileNumber") String user_mobile,
            @Field("Message") String user_message
            );

    @GET("api/loadrequestInfo.php")
    Call<Users> requestShowing(
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Message") String user_mess

    );



    @FormUrlEncoded
    @POST("api/addProperty.php")
    Call<Users>addProperty(
            @Field("UserID") String user_iid,
            @Field("PropertyTitle") String pro_title,
            @Field("PropertDescription") String pro_dec,
            @Field("Status") String pro_status,
            @Field("Location") String pro_location,
            @Field("Bedrooms") String pro_bed,
            @Field("Bathrooms") String pro_bath,
            @Field("Floors") String pro_floor,
            @Field("Garages") String pro_garage,
            @Field("Area") String pro_area,
            @Field("Size") String pro_size,
            @Field("RentorsalePrice") String pro_resale,
            @Field("FeaturedImage") String image,
            @Field("Address") String pro_address,
            @Field("City") String pro_city

    );


    @FormUrlEncoded
    @POST("add.php")
    Call<Users>add (
            @Field("UserID") String user_iid,
            @Field("PropertyTitle") String pro_title,
            @Field("PropertDescription") String pro_dec,
            @Field("Status") String pro_status,
            @Field("Location") String pro_location,
            @Field("Bedrooms") String pro_bed,
            @Field("Bathrooms") String pro_bath,
            @Field("Floors") String pro_floor,
            @Field("Garages") String pro_garage,
            @Field("Area") String pro_area,
            @Field("Size") String pro_size,
            @Field("RentorsalePrice") String pro_resale,
            @Field("FeaturedImage") String image,
            @Field("Address") String pro_address,
            @Field("City") String pro_city

    );



    @FormUrlEncoded
    @POST("upDay.php")
    Call<Users>upPro(
            @Field("ID") String id,
            @Field("UserID") String user_iid,
            @Field("PropertyTitle") String pro_title,
            @Field("PropertDescription") String pro_dec,
            @Field("Status") String pro_status,
            @Field("Location") String pro_location,
            @Field("Bedrooms") String pro_bed,
            @Field("Bathrooms") String pro_bath,
            @Field("Floors") String pro_floor,
            @Field("Garages") String pro_garage,
            @Field("Area") String pro_area,
            @Field("Size") String pro_size,
            @Field("RentorsalePrice") String pro_resale,
            @Field("FeaturedImage") String image,
            @Field("Address") String pro_address,
            @Field("City") String pro_city

    );




    @POST("api/addProperty.php")
    @Multipart
    Call<Users> addProfile(
            @Part ("UserID") String pro_name1,
            @Part ("PropertyTitle") String pro_title1,
            @Part ("PropertDescription") String pro_desc1,
            @Part ("Status") String pro_status1,
            @Part ("Location") String pro_loca1,
            @Part ("Bedrooms") String pro_beds1,
            @Part ("Bathrooms") String pro_baths1,
            @Part ("Floors") String pro_floors1,
            @Part ("Garages") String pro_garages1,
            @Part ("Area") String pro_area1,
            @Part ("Size") String pro_size1,
            @Part ("RentorsalePrice") String pro_price1,
            @Part MultipartBody.Part picFile,
            @Part ("Address") String pro_addres1,
            @Part ("City") String pro_city1

    );

    @FormUrlEncoded
    @POST("api/kayiwa.php")
    Call<Users>addKayiwa(
            @Field("title") String title,
            @Field("image") String image
            );

    @GET("api/insertreview.php")
    Call<Users> insertReview(
//            @Query("UserId") String user_id,
//            @Query("PropertyId") String pro_id,
            @Query("UserRemark") String user_remark


    );



    @GET("getUser.php")
    Call<Users> getPropertyById(
            @Query("UserID") String id
    );


    @GET("api/property.php")
   Call<Users> getProperties();

    @POST("api/myproperties.php")
    Call<Users> getMyProperties(
            @Query("UserID") String UserI
//
    );




    @GET("api/propertytype.php")
    Call<Users> getPropertyType();



    // @GET("api/state.php")
    //Call<Users> getProperties (@Query("key") String keyword
    //);



}
