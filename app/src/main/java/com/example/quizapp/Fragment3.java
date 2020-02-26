package com.example.quizapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    private MainViewModel mainViewModel;
    private RecyclerFragmentAdapter recyclerFragmentAdapter;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        final RecyclerView recyclerView = v.findViewById(R.id.recyclerview);
        recyclerFragmentAdapter = new RecyclerFragmentAdapter();
        recyclerView.setAdapter(recyclerFragmentAdapter);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.counter.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                recyclerFragmentAdapter.addText(integer.toString());
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

}
