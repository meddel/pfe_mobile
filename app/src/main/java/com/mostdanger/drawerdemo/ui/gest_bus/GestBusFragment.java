package com.mostdanger.drawerdemo.ui.gest_bus;

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

public class GestBusFragment extends Fragment {

    private GestBusViewModel gestBusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gestBusViewModel =
                ViewModelProviders.of(this).get(GestBusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gest_bus, container, false);
        final TextView textView = root.findViewById(R.id.text_gest_bus);
        gestBusViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
