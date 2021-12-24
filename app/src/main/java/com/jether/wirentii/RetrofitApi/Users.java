package com.jether.wirentii.RetrofitApi;

import com.google.gson.annotations.SerializedName;
import com.jether.wirentii.Model.ModelPropertyType;
import com.jether.wirentii.Model.MyPropertyModel;
import com.jether.wirentii.Model.PropertyModel;
import com.jether.wirentii.Model.PropertyModelOwner;

import java.util.ArrayList;

public class Users {


    @SerializedName("response")
    private String Response;

    @SerializedName("ID")
    private String UserId;

    @SerializedName("UserType")
    private String UserTy;

    @SerializedName("FullName")
    private String UserName;

    @SerializedName("Email")
    private String UserEmail;

    @SerializedName("MobileNumber")
    private String UserMobi;

    @SerializedName("Password")
    private String UserPass;

    @SerializedName("Aboutme")
    private String UserAbout;



    @SerializedName("UserID")
    private String UserrrrID1;

     @SerializedName("PropertyTitle")
    private String UserTitl1;

     @SerializedName("PropertDescription")
    private String UserProp1;

     @SerializedName("Type")
    private String UserType1;

     @SerializedName("Status")
    private String UserStat1;

     @SerializedName("Location")
    private String UserLocati1;

     @SerializedName("Bedrooms")
    private String UserBedroom1;

     @SerializedName("Bathrooms")
    private String UserBathroo1;

     @SerializedName("Floors")
    private String UserFloor1;

     @SerializedName("Garages")
    private String UserGarage1;

     @SerializedName("Area")
    private String UserArea1;

     @SerializedName("RentorsalePrice")
    private String UserRentor1;

 @SerializedName("BeforePriceLabel")
    private String UserBefor1;

 @SerializedName("AfterPriceLabel")
    private String UserAfter1;

 @SerializedName("CenterCooling")
    private String UserCenter1;

 @SerializedName("Balcony")
    private String UserBalcony1;

 @SerializedName("PetFriendly")
    private String UserPet1;


 @SerializedName("Barbeque")
    private String UserBerb1;

 @SerializedName("FireAlarm")
    private String UserFire1;

 @SerializedName("ModernKitchen")
    private String UserKith1;

 @SerializedName("Storage")
    private String UserStor1;

 @SerializedName("Dryer")
    private String UserDryer1;

 @SerializedName("Heating")
    private String UserHeat1;

 @SerializedName("Pool")
    private String UserPool1;

 @SerializedName("Laundry")
    private String UserLund1;

 @SerializedName("Sauna")
    private String UserSau1;

 @SerializedName("Gym")
    private String UserGy1;

 @SerializedName("Elevator")
    private String UserEle1;

 @SerializedName("Dishwasher")
    private String UserDish1;

 @SerializedName("EmergencyExit")
    private String UserEmer1;

 @SerializedName("Address")
    private String UserAd1;

 @SerializedName("Country")
    private String UserCoun1;

 @SerializedName("City")
    private String UserCi1;

 @SerializedName("State")
    private String UserSta1;

 @SerializedName("ZipCode")
    private String UserZip1;

 @SerializedName("Neighborhood")
    private String UserHood1;

 @SerializedName("FeaturedImage")
    private String UserFe1;

 @SerializedName("GalleryImage1")
    private String UserGala1;

 @SerializedName("GalleryImage2")
    private String UserGala2;

 @SerializedName("GalleryImage3")
    private String UserGala3;

 @SerializedName("GalleryImage4")
    private String UserGala4;

@SerializedName("GalleryImage5")
    private String UserGala5;



    @SerializedName("properties")
    private ArrayList<PropertyModel> property;


    @SerializedName("MyProperties")
    private ArrayList<MyPropertyModel> propertyMine;



    @SerializedName("tblpropertytype")
    private ArrayList<ModelPropertyType> propertType;

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserTy() {
        return UserTy;
    }

    public void setUserTy(String userTy) {
        UserTy = userTy;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserMobi() {
        return UserMobi;
    }

    public void setUserMobi(String userMobi) {
        UserMobi = userMobi;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public String getUserAbout() {
        return UserAbout;
    }

    public void setUserAbout(String userAbout) {
        UserAbout = userAbout;
    }

    public String getUserrrrID1() {
        return UserrrrID1;
    }

    public void setUserrrrID1(String userrrrID1) {
        UserrrrID1 = userrrrID1;
    }

    public String getUserTitl1() {
        return UserTitl1;
    }

    public void setUserTitl1(String userTitl1) {
        UserTitl1 = userTitl1;
    }

    public String getUserProp1() {
        return UserProp1;
    }

    public void setUserProp1(String userProp1) {
        UserProp1 = userProp1;
    }

    public String getUserType1() {
        return UserType1;
    }

    public void setUserType1(String userType1) {
        UserType1 = userType1;
    }

    public String getUserStat1() {
        return UserStat1;
    }

    public void setUserStat1(String userStat1) {
        UserStat1 = userStat1;
    }

    public String getUserLocati1() {
        return UserLocati1;
    }

    public void setUserLocati1(String userLocati1) {
        UserLocati1 = userLocati1;
    }

    public String getUserBedroom1() {
        return UserBedroom1;
    }

    public void setUserBedroom1(String userBedroom1) {
        UserBedroom1 = userBedroom1;
    }

    public String getUserBathroo1() {
        return UserBathroo1;
    }

    public void setUserBathroo1(String userBathroo1) {
        UserBathroo1 = userBathroo1;
    }

    public String getUserFloor1() {
        return UserFloor1;
    }

    public void setUserFloor1(String userFloor1) {
        UserFloor1 = userFloor1;
    }

    public String getUserGarage1() {
        return UserGarage1;
    }

    public void setUserGarage1(String userGarage1) {
        UserGarage1 = userGarage1;
    }

    public String getUserArea1() {
        return UserArea1;
    }

    public void setUserArea1(String userArea1) {
        UserArea1 = userArea1;
    }

    public String getUserRentor1() {
        return UserRentor1;
    }

    public void setUserRentor1(String userRentor1) {
        UserRentor1 = userRentor1;
    }

    public String getUserBefor1() {
        return UserBefor1;
    }

    public void setUserBefor1(String userBefor1) {
        UserBefor1 = userBefor1;
    }

    public String getUserAfter1() {
        return UserAfter1;
    }

    public void setUserAfter1(String userAfter1) {
        UserAfter1 = userAfter1;
    }

    public String getUserCenter1() {
        return UserCenter1;
    }

    public void setUserCenter1(String userCenter1) {
        UserCenter1 = userCenter1;
    }

    public String getUserBalcony1() {
        return UserBalcony1;
    }

    public void setUserBalcony1(String userBalcony1) {
        UserBalcony1 = userBalcony1;
    }

    public String getUserPet1() {
        return UserPet1;
    }

    public void setUserPet1(String userPet1) {
        UserPet1 = userPet1;
    }

    public String getUserBerb1() {
        return UserBerb1;
    }

    public void setUserBerb1(String userBerb1) {
        UserBerb1 = userBerb1;
    }

    public String getUserFire1() {
        return UserFire1;
    }

    public void setUserFire1(String userFire1) {
        UserFire1 = userFire1;
    }

    public String getUserKith1() {
        return UserKith1;
    }

    public void setUserKith1(String userKith1) {
        UserKith1 = userKith1;
    }

    public String getUserStor1() {
        return UserStor1;
    }

    public void setUserStor1(String userStor1) {
        UserStor1 = userStor1;
    }

    public String getUserDryer1() {
        return UserDryer1;
    }

    public void setUserDryer1(String userDryer1) {
        UserDryer1 = userDryer1;
    }

    public String getUserHeat1() {
        return UserHeat1;
    }

    public void setUserHeat1(String userHeat1) {
        UserHeat1 = userHeat1;
    }

    public String getUserPool1() {
        return UserPool1;
    }

    public void setUserPool1(String userPool1) {
        UserPool1 = userPool1;
    }

    public String getUserLund1() {
        return UserLund1;
    }

    public void setUserLund1(String userLund1) {
        UserLund1 = userLund1;
    }

    public String getUserSau1() {
        return UserSau1;
    }

    public void setUserSau1(String userSau1) {
        UserSau1 = userSau1;
    }

    public String getUserGy1() {
        return UserGy1;
    }

    public void setUserGy1(String userGy1) {
        UserGy1 = userGy1;
    }

    public String getUserEle1() {
        return UserEle1;
    }

    public void setUserEle1(String userEle1) {
        UserEle1 = userEle1;
    }

    public String getUserDish1() {
        return UserDish1;
    }

    public void setUserDish1(String userDish1) {
        UserDish1 = userDish1;
    }

    public String getUserEmer1() {
        return UserEmer1;
    }

    public void setUserEmer1(String userEmer1) {
        UserEmer1 = userEmer1;
    }

    public String getUserAd1() {
        return UserAd1;
    }

    public void setUserAd1(String userAd1) {
        UserAd1 = userAd1;
    }

    public String getUserCoun1() {
        return UserCoun1;
    }

    public void setUserCoun1(String userCoun1) {
        UserCoun1 = userCoun1;
    }

    public String getUserCi1() {
        return UserCi1;
    }

    public void setUserCi1(String userCi1) {
        UserCi1 = userCi1;
    }

    public String getUserSta1() {
        return UserSta1;
    }

    public void setUserSta1(String userSta1) {
        UserSta1 = userSta1;
    }

    public String getUserZip1() {
        return UserZip1;
    }

    public void setUserZip1(String userZip1) {
        UserZip1 = userZip1;
    }

    public String getUserHood1() {
        return UserHood1;
    }

    public void setUserHood1(String userHood1) {
        UserHood1 = userHood1;
    }

    public String getUserFe1() {
        return UserFe1;
    }

    public void setUserFe1(String userFe1) {
        UserFe1 = userFe1;
    }

    public String getUserGala1() {
        return UserGala1;
    }

    public void setUserGala1(String userGala1) {
        UserGala1 = userGala1;
    }

    public String getUserGala2() {
        return UserGala2;
    }

    public void setUserGala2(String userGala2) {
        UserGala2 = userGala2;
    }

    public String getUserGala3() {
        return UserGala3;
    }

    public void setUserGala3(String userGala3) {
        UserGala3 = userGala3;
    }

    public String getUserGala4() {
        return UserGala4;
    }

    public void setUserGala4(String userGala4) {
        UserGala4 = userGala4;
    }

    public String getUserGala5() {
        return UserGala5;
    }

    public void setUserGala5(String userGala5) {
        UserGala5 = userGala5;
    }

    public ArrayList<PropertyModel> getProperty() {
        return property;
    }

    public void setProperty(ArrayList<PropertyModel> property) {
        this.property = property;
    }

    public ArrayList<MyPropertyModel> getPropertyMine() {
        return propertyMine;
    }

    public void setPropertyMine(ArrayList<MyPropertyModel> propertyMine) {
        this.propertyMine = propertyMine;
    }

    public ArrayList<ModelPropertyType> getPropertType() {
        return propertType;
    }

    public void setPropertType(ArrayList<ModelPropertyType> propertType) {
        this.propertType = propertType;
    }
}
