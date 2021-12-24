package com.jether.wirentii.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.jether.wirentii.Adapter.AdapterPropertyOwner;
import com.jether.wirentii.Adapter.SliderAdapterExample;
import com.jether.wirentii.BottomActivity;
import com.jether.wirentii.DashboardActivity;
import com.jether.wirentii.EditPropertyActivity;
import com.jether.wirentii.Model.ImageSliderModel;
import com.jether.wirentii.Model.PropertyModel;
import com.jether.wirentii.R;
import com.jether.wirentii.RetrofitApi.ApiClient;
import com.jether.wirentii.RetrofitApi.ApiInterface;
import com.jether.wirentii.RetrofitApi.Users;
import com.jether.wirentii.Sessions.SharedPrefManager;
import com.jether.wirentii.UpdateActivity;
import com.scwang.wave.MultiWaveHeader;
import com.smarteist.autoimageslider.SliderView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerHomeFragment extends Fragment implements Serializable {

    public static ApiInterface apiInterface;

    RecyclerView rv;

    private String user_nameee,user_email;


    int page =1,limit=3;

    TextView logo,reg,wel;
    Button logo2,reg2;
    Button Cancel1,Can;

    TextView up1;
    TextView jay;
    EditText full,eme,mo,pa;
    EditText eme2,pa2;
    RadioGroup radioGroup;
    RadioButton selectedType;
    TextView textView;

    private SearchView searchView;
    MultiWaveHeader multi;

    String user_id;

    SharedPrefManager sharedPrefManager;
    TextView current,latest;
    ArrayList<PropertyModel> property1= new ArrayList<>();
    AdapterPropertyOwner adapterPropertyOwner;

    public OwnerHomeFragment() {


    }

    private View view;

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_owner_home, container, false);

        sharedPrefManager= new SharedPrefManager(getContext());

        logo=view.findViewById(R.id.textView17);
        wel=view.findViewById(R.id.textView15);
        searchView=view.findViewById(R.id.search);
        up1=view.findViewById(R.id.textView32);

        jay=view.findViewById(R.id.textView15);

        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String kajoee=kojo.get(SharedPrefManager.NAME);


        jay.setText("Welcome Back"+"\n"+kajoee);

        //initialize connection manager



//
//        ConnectivityManager connectivityManager=(ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        //get active network info
//        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
//
//        //check network status
//        if(networkInfo==null || !networkInfo.isConnected() || !networkInfo.isAvailable()){
//            //when internet is active
//
//            Intent intent = new Intent(getContext(), NoInternetActivity.class);
//            startActivity(intent);
//
//        }else{
//            //when internet is active
//            //init();
//        }


        //Users users=sharedPrefManager.getInstance(getContext()).getUser();
//        jay.setText("Welcome Back"+users.getUserName());

        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), UpdateActivity.class);
                startActivity(intent);

            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<PropertyModel>filterProperty=filter(property1,newText);
                adapterPropertyOwner.setfilter(filterProperty);

                return false;
            }
        });





        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefManager.editor.clear();
                sharedPrefManager.editor.commit();
                Intent intent= new Intent(getActivity(), BottomActivity.class);
                startActivity(intent);
                getActivity().finish();
                Animatoo.animateSlideLeft(getContext());

            }

        });

        imageSliderModelList=new ArrayList<>();
        sliderView=view.findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.a));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.b));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.c));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.d));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.e));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.f));


        sliderView.setSliderAdapter(new SliderAdapterExample(getContext(),imageSliderModelList));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(getContext());





        init();

        return view;
    }




    private void init() {

        rv=view.findViewById(R.id.pro);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(getContext());
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        property1= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getProperties();
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                property1=response.body().getProperty();

                adapterPropertyOwner= new AdapterPropertyOwner(property1,getContext());
                rv.setAdapter(adapterPropertyOwner);
                adapterPropertyOwner.notifyDataSetChanged();



            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }




    private List<PropertyModel>filter(ArrayList<PropertyModel> hi, String query){
        query=query.toLowerCase();
        final List<PropertyModel>filterModeList=new ArrayList<>();
        for (PropertyModel modal:hi){
            final String text=modal.getPropertyTitle().toLowerCase();
            final String text1=modal.getStatus().toLowerCase();
            final String text2=modal.getAddress().toLowerCase();

            if (text.startsWith(query)){
                filterModeList.add(modal);
            }
            else if (text1.startsWith(query)){
                filterModeList.add(modal);
            }
            else if (text2.startsWith(query)){
                filterModeList.add(modal);
            }

        }

        return filterModeList;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(getContext(), BottomActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }
}
