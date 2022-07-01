package com.example.tugaspertemuan3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AboutFragment extends Fragment {

    String s1[], s2[];
    int images[] = {R.drawable.python, R.drawable.java, R.drawable.php, R.drawable.react, R.drawable.c_plus_plus, R.drawable.swift, R.drawable.kotlin, R.drawable.javascript};
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);
        recyclerView = rootView.findViewById(R.id.rv_programmingLanguages);

        Adapter adapter = new Adapter(getActivity(), s1, s2, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}