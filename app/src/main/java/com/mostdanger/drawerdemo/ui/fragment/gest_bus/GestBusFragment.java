package com.mostdanger.drawerdemo.ui.fragment.gest_bus;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.adapter.BusAdapter;
import com.mostdanger.drawerdemo.dialog.AjoutBusDialog;
import com.mostdanger.drawerdemo.entities.Bus;
import com.mostdanger.drawerdemo.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class GestBusFragment extends Fragment {

    private GestBusViewModel gestBusViewModel;
    private FloatingActionButton add_button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gestBusViewModel =
                ViewModelProviders.of(this).get(GestBusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gest_bus, container, false);
        List<Bus> buses = new ArrayList<>();
        buses = loadBuses();
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        add_button = root.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AjoutBusDialog ajoutBusDialog = new AjoutBusDialog(getActivity());
                ajoutBusDialog.show();
            }

        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        final BusAdapter adapter = new BusAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setBuses(buses);
        return root;
    }

    private List<Bus> loadBuses() {
        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus(12, "sfax", "17/09/2020"));
        buses.add(new Bus(13, "sfax sud", "17/09/2020"));
        buses.add(new Bus(14, "sfax north", "17/09/2020"));
        return buses;
    }
}
