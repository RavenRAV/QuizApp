package com.example.quizapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {
    private MainViewModel mainViewModel;
    private RecyclerFragmentAdapter adapter;
    private RecyclerView recyclerView;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new RecyclerFragmentAdapter();
        recyclerView.setAdapter(adapter);

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.mResults.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                adapter.addText(integer.toString());
            }
        });

        return v;
    }

}
