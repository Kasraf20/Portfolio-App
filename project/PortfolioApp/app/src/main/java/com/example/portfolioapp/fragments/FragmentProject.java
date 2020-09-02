package com.example.portfolioapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.portfolioapp.AdapterClient;
import com.example.portfolioapp.ClientModel;
import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProject extends Fragment {

    List<ClientModel> clientModels;
    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridview);
        clientModels = new ArrayList<>();

        clientModels.add(new ClientModel("python",R.drawable.python));
        clientModels.add(new ClientModel("java",R.drawable.java));
        clientModels.add(new ClientModel("c",R.drawable.c));
        clientModels.add(new ClientModel("javascript",R.drawable.javascript));
        clientModels.add(new ClientModel("php",R.drawable.php));
        clientModels.add(new ClientModel("android",R.drawable.android));

        AdapterClient adapterClient = new AdapterClient(getContext(),clientModels);
        gridView.setAdapter(adapterClient);
    }
}
