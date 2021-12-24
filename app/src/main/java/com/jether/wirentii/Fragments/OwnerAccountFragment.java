package com.jether.wirentii.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.jether.wirentii.AddPropertyActivity;
import com.jether.wirentii.BottomActivity;
import com.jether.wirentii.ChangePasswordActivity;
import com.jether.wirentii.DashboardActivity;
import com.jether.wirentii.EditProfileActivity;
import com.jether.wirentii.GataActivity;
import com.jether.wirentii.LogOutActivity;
import com.jether.wirentii.MyPropertiesActivity;
import com.jether.wirentii.R;
import com.jether.wirentii.Sessions.SharedPrefManager;

public class OwnerAccountFragment extends Fragment {

    public OwnerAccountFragment() {
    }

    CircleMenu circleMenu;
    CardView emu,biri,satu,nya,tano;

    private View view;

    SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_owner_account, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());


        emu=view.findViewById(R.id.linear1);
        //biri=view.findViewById(R.id.linear2);
        satu=view.findViewById(R.id.linear3);
        nya=view.findViewById(R.id.linear4);
        tano=view.findViewById(R.id.linear5);


        emu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);

            }
        });

//        biri.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getContext(), ChangePasswordActivity.class);
//                startActivity(intent);
//            }
//        });

        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), GataActivity.class);
                startActivity(intent);
            }
        });

        nya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), MyPropertiesActivity.class);
                startActivity(intent);
            }
        });


        tano.setOnClickListener(new View.OnClickListener() {
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

        return view;
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
