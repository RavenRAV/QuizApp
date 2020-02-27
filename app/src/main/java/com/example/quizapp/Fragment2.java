package com.example.quizapp;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    private MainViewModel fragVM;
    private TextView res;

    public Fragment2() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        res = v.findViewById(R.id.res);
        fragVM = ViewModelProviders
                .of(getActivity())
                .get(MainViewModel.class);
        fragVM.counter.observe(this, new Observer<Integer>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged(Integer integer) {
                if (integer != null) {
                    res.setText(integer.toString());
                }
            }
        });
        return v;
    }


}
