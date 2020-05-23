package com.example.mydashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//row count in grid layout is fixed set... need to change it acc to user
/**
 * A simple {@link Fragment} subclass.
 */
public class AllClasses extends Fragment {

    public AllClasses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_classes, container, false);
    }
}
