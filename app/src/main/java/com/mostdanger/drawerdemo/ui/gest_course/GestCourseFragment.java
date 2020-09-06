package com.mostdanger.drawerdemo.ui.gest_course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.gest_bus.GestBusViewModel;

public class GestCourseFragment extends Fragment {

    private GestCourseViewModel gestCourseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gestCourseViewModel =
                ViewModelProviders.of(this).get(GestCourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gest_course, container, false);
        final TextView textView = root.findViewById(R.id.text_gest_course);
        gestCourseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
