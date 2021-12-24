package com.jether.wirentii.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jether.wirentii.BottomActivity;
import com.jether.wirentii.R;
import com.jether.wirentii.Sessions.SharedPrefManager;

public class OwnerAboutUsFragment extends Fragment {

    public OwnerAboutUsFragment() {
    }


    private View view;

    SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fargment_owner_about, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());

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
