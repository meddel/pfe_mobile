package com.mostdanger.drawerdemo.ui.home.map_dial;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mostdanger.drawerdemo.R;

import java.util.HashMap;
import java.util.Map;


public class MapDial extends AppCompatDialogFragment {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public TextView longitude;
    public TextView latitude;
    private EditText name;


    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater= getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.add_station_dial, null);
        latitude=view.findViewById(R.id.textViewLat);
        longitude=view.findViewById(R.id.textViewLong);
        name=view.findViewById(R.id.stationName);
        assert this.getArguments() != null;
        final String strLng=this.getArguments().getString("latitude");
        final String strLat=this.getArguments().getString("longitude");
        String c= (String) latitude.getText();
        String c2= (String) longitude.getText();
        latitude.setText(c+strLat );
        longitude.setText(c2+strLng );




        builder.setView(view)
                .setTitle("ajouter station par map")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nom= String.valueOf(name.getText());
                        Map<String,Object> station=new HashMap<>();
                        station.put("nomStation",nom);
                        station.put("longitude",strLng);
                        station.put("latitude",strLat);

                        db.collection("station").document().set(station);


                    }
                });

        return builder.create();

                }
    }

