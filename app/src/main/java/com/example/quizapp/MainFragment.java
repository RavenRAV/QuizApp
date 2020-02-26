package com.example.quizapp;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private TextView mCounterTV;
    private MainViewModel mFragVM;
    private View v;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.main_fragment, container, false);
        initView();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragVM = ViewModelProviders
                .of(getActivity())
                .get(MainViewModel.class);
//
//        mFragVM.listMutableLiveData.observe(getActivity(), new Observer<ArrayList<Integer>>() {
//            @Override
//            public void onChanged(ArrayList<Integer> strings) {
//                mCounterTV.setText();
//            }
//        });
        mFragVM.counter.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mCounterTV.setText(integer.toString());
            }
        });
    }

//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onChanged(Integer integer) {
//                if (integer != null) {
//
//                }
//            }
//        });


        private void initView () {
            mCounterTV = v.findViewById(R.id.counter);
            v.findViewById(R.id.btn_increment).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragVM.onIncrementClick();
                }
            });
            v.findViewById(R.id.btn_reduction).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragVM.onReductionClick();
                }
            });
        }
    }

