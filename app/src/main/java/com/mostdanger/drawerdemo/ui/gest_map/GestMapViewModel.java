package com.mostdanger.drawerdemo.ui.gest_map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GestMapViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GestMapViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gestMap fragment");
    }

    public LiveData<String> getText() {

        return mText;
    }
}