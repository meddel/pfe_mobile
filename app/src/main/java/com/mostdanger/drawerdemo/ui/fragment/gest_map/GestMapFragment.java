package com.mostdanger.drawerdemo.ui.fragment.gest_map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.fragment.home.map_dial.MapDial;

public class GestMapFragment extends Fragment {

    private GestMapViewModel gestMapViewModel;
    private ImageView imageView2;
    private ImageView imageView4;
    MapDial mapDial=new MapDial();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_gest_map, null);
        imageView2=view.findViewById(R.id.imageV2);
        imageView4=view.findViewById(R.id.imageV4);
        gestMapViewModel =
                ViewModelProviders.of(this).get(GestMapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gest_map, container, false);
        //final TextView textView = root.findViewById(R.id.text_gest_map);
        gestMapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

            }
        });

        return root;
    }
}
