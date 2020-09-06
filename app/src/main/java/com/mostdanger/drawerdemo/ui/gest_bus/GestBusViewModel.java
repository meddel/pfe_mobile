package com.mostdanger.drawerdemo.ui.gest_bus;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GestBusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GestBusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gestBus fragment");
    }

    public LiveData<String> getText() {

        return mText;
    }
}