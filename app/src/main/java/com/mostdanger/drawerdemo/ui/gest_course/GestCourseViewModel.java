package com.mostdanger.drawerdemo.ui.gest_course;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GestCourseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GestCourseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gestCourse fragment");
    }

    public LiveData<String> getText() {

        return mText;
    }
}