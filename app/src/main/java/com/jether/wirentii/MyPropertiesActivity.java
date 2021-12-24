package com.jether.wirentii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.jether.wirentii.Adapter.AdapterMyProperties;
import com.jether.wirentii.Adapter.AdapterProperty;
import com.jether.wirentii.Adapter.AdapterPropertyOwner;
import com.jether.wirentii.Adapter.SliderAdapterExample;
import com.jether.wirentii.Model.ImageSliderModel;
import com.jether.wirentii.Model.MyPropertyModel;
import com.jether.wirentii.Model.PropertyModel;
import com.jether.wirentii.RetrofitApi.ApiClient;
import com.jether.wirentii.RetrofitApi.ApiInterface;
import com.jether.wirentii.RetrofitApi.Users;
import com.jether.wirentii.Sessions.SharedPrefManager;
import com.smarteist.autoimageslider.SliderView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



    public class MyPropertiesActivity extends AppCompatActivity {
        RecyclerView rv;
        TextView logo;
        ImageView back;
        public static ApiInterface apiInterface;

        private String id;

        TextView uza;

    SharedPrefManager sharedPrefManager;

    ArrayList<MyPropertyModel> property2= new ArrayList<>();

    AdapterMyProperties adapterPropertyMy;

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;



    String user_id;

    String user_typp;
    String user_moo;
    String user_namee;
    String user_emaill;
    String user_passs;
    String user_about1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_properties);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager= new SharedPrefManager(this);


        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String muntu=kojo.get(SharedPrefManager.ID);

        logo=findViewById(R.id.textView17);
        uza=findViewById(R.id.naye);
        back=findViewById(R.id.back);
        uza.setText(muntu);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefManager.editor.clear();
                sharedPrefManager.editor.commit();
                Intent intent= new Intent(MyPropertiesActivity.this, BottomActivity.class);
                startActivity(intent);
                finish();
                Animatoo.animateSlideLeft(MyPropertiesActivity.this);

            }

        });

        imageSliderModelList=new ArrayList<>();
        sliderView=findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.a));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.b));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.c));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.d));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.e));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.f));


        sliderView.setSliderAdapter(new SliderAdapterExample(MyPropertiesActivity.this,imageSliderModelList));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MyPropertiesActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });


        init();
    }

    private void init() {

        rv=findViewById(R.id.pro);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(this);
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        String ya=uza.getText().toString().trim();

        property2= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getPropertyById(ya);
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                property2 = response.body().getPropertyMine();

                adapterPropertyMy = new AdapterMyProperties(property2, MyPropertiesActivity.this);
                rv.setAdapter(adapterPropertyMy);
                adapterPropertyMy.notifyDataSetChanged();


            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }






    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(MyPropertiesActivity.this,BottomActivity.class);
            startActivity(intent);
        }else{

        }
    }

}