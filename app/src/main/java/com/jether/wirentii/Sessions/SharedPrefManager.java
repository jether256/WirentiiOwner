package com.jether.wirentii.Sessions;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedPrefManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    private Context mCtx;
    int PRIVATE_MODE = 0;

    private static final String SHARED_PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = " NAME ";
    public static final String EMAIL = "EMAIL";
    public static final String USERTYPE = "USERTYPE";
    public static final String MOBILE = "MOBILE";
    public static final String PASSWORD = "PASSWORD";
    public static final String ABOUTME = "ABOUTME";
    public static final String ID = "ID";


    public static final String D = "ID";
    public static final String UserID= "UserID";
    public static final String PropertyTitle = "PropertyTitle";
    public static final String PropertDescription= "PropertDescription";
    public static final String Status= "Status";
    public static final String Location = "Location";
    public static final String Bedrooms = "Bedrooms";
    public static final String Bathrooms = "Bathrooms";
    public static final String Floors = "Floors";
    public static final String Garages = "Garages";
    public static final String Area = "Area";
    public static final String Size = "Size";
    public static final String RentorsalePrice = "RentorsalePrice";
    public static final String PropertyID = "PropertyID";
    public static final String FeaturedImage = "FeaturedImage";
    public static final String Address = "Address";
    public static final String City = "City";


    public SharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
        sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

//    public static synchronized  SharedPrefManager getInstance(Context mCtx){
//        if(mInstance==null){
//            mInstance= new SharedPrefManager(mCtx);
//        }
//        return mInstance;
//    }


    public void createSession(String user_id,String user_namee,String user_emaill,String user_typp,String user_moo,String user_passs,String user_aboutsss ) {
        editor.putBoolean(LOGIN, true);
        editor.putString(ID, user_id);
       editor.putString(NAME, user_namee);
        editor.putString(EMAIL, user_emaill);
        editor.putString(USERTYPE, user_typp);
       editor.putString(MOBILE, user_moo);
        editor.putString(PASSWORD, user_passs);
        editor.putString(ABOUTME, user_aboutsss);
        editor.apply();
    }


    public void saveProperty(String property_id,String user_iid,String property_ti,String property_d,String pro_status,String pro_location,
                             String pro_bed,String pro_bath,String pro_floors,String pro_gara,String pro_area,String pro_size,String pro_price,
                             String pro_prope ,String pro_image,String pro_address,String pro_city) {
        editor.putBoolean(LOGIN, true);
        editor.putString(D, property_id);
        editor.putString(UserID, user_iid);
        editor.putString(PropertyTitle, property_ti);
        editor.putString(PropertDescription, property_d);
        editor.putString(Status, pro_status);
        editor.putString(Location, pro_location);
        editor.putString(Bedrooms, pro_bed);
        editor.putString(Bathrooms, pro_bath);
        editor.putString(Floors, pro_floors);
        editor.putString(Garages, pro_gara);
        editor.putString(Area, pro_area);
        editor.putString(Size, pro_size);
        editor.putString(RentorsalePrice, pro_price);
        editor.putString(PropertyID, pro_prope);
        editor.putString(FeaturedImage, pro_image);
        editor.putString(Address, pro_address);
        editor.putString(City, pro_city);
        editor.apply();
    }

    public  boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }


    public HashMap<String, String> getUserDetail() {

    HashMap<String, String> user = new HashMap<>();
    user.put(ID,sharedPreferences.getString(ID,null));
    user.put(NAME,sharedPreferences.getString(NAME,null));
    user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
    user.put(USERTYPE,sharedPreferences.getString(USERTYPE,null));
    user.put(MOBILE,sharedPreferences.getString(MOBILE,null));
    user.put(PASSWORD,sharedPreferences.getString(PASSWORD,null));
    user.put(ABOUTME,sharedPreferences.getString(ABOUTME,null));

    return user;
    }

    public HashMap<String, String> getPropertyDetail() {

        HashMap<String, String> pro = new HashMap<>();
        pro.put(D,sharedPreferences.getString(D,null));
        pro.put(UserID,sharedPreferences.getString(UserID,null));
        pro.put(PropertyTitle,sharedPreferences.getString(PropertyTitle,null));
        pro.put(PropertDescription,sharedPreferences.getString(PropertDescription,null));
        pro.put(Status,sharedPreferences.getString(Status,null));
        pro.put(Location,sharedPreferences.getString(Location,null));
        pro.put(Bedrooms,sharedPreferences.getString(Bedrooms,null));
        pro.put(Bathrooms,sharedPreferences.getString(Bathrooms,null));
        pro.put(Floors,sharedPreferences.getString(Floors,null));
        pro.put(Garages,sharedPreferences.getString(Garages,null));
        pro.put(Area,sharedPreferences.getString(Area,null));
        pro.put(Size,sharedPreferences.getString(Size,null));
        pro.put(RentorsalePrice,sharedPreferences.getString(RentorsalePrice,null));
        pro.put(PropertyID,sharedPreferences.getString(PropertyID,null));
        pro.put(FeaturedImage,sharedPreferences.getString(FeaturedImage,null));
        pro.put(Address,sharedPreferences.getString(Address,null));
        pro.put(City,sharedPreferences.getString(City,null));


        return pro;
    }





}
