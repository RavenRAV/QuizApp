package com.example.quizapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private int mCounter = 0;
    public MutableLiveData<Integer> counter = new MutableLiveData<>();

    void onIncrementClick() {
        mCounter++;
        counter.setValue(mCounter);
    }

    void onReductionClick() {
        mCounter--;
        counter.setValue(mCounter);
    }
}
