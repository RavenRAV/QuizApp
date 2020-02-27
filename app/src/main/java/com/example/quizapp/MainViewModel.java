package com.example.quizapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private Integer mCounter = 0;
    public MutableLiveData<Integer> counter = new MutableLiveData<>();
    public MutableLiveData<Integer> mResults = new MutableLiveData<>();


    void onIncrementClick() {
        mCounter++;
        counter.setValue(mCounter);
        mResults.postValue(mCounter);
    }

    void onReductionClick() {
        mCounter--;
        counter.setValue(mCounter);
        mResults.postValue(mCounter);
    }
}
