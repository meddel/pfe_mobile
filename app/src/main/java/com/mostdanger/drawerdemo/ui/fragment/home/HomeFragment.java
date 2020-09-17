package com.mostdanger.drawerdemo.ui.fragment.home;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.ui.fragment.home.map_dial.MapDial;

import static com.mostdanger.drawerdemo.ui.activity.MainActivity.account_type;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private static String TAG = "Map Fragment";
    private HomeViewModel homeViewModel;
    private MapView mapView;
    public LocationListener locationListener;
    public LocationManager locationManager;
    private final long MIN_TIME = 1000;
    private final long MIN_DIST = 5;
    private DatabaseReference databaseReference;
    public FusedLocationProviderClient fusedLocationClient;



    public void openDialog_map(LatLng point) {
        MapDial mapDial = new MapDial();
        Bundle b=new Bundle();
        b.putString("latitude",Double.toString(point.latitude));
        b.putString("longitude",Double.toString(point.longitude));
        mapDial.setArguments(b);
        mapDial.showNow(getParentFragmentManager(), "add station");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        mapView = (MapView) root.findViewById(R.id.mapView);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        initMap(savedInstanceState, mapView);

        return root;
    }

    private void initMap(Bundle savedInstanceState, final MapView mapView) {
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(final GoogleMap googleMap) {

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                if (location != null) {
                                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                                        if (location != null) {
                                            // Logic to handle location object
                                        }
                                    }
                            }
                        });
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        try {
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                            Toast.makeText(getContext(),
                                    "before zoom",
                                    Toast.LENGTH_SHORT).show();
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point) {

                        Log.d("myTag", "your account type is "+account_type);
                        Toast.makeText(getContext(),
                                "your account type is "+account_type,
                                Toast.LENGTH_SHORT).show();
                        /*
                          allPoints.add(point);
                          googleMap.clear();
                          **add marker to map on click
                          googleMap.addMarker(new MarkerOptions().position(point));*/
                        if(account_type=="admin")
                        openDialog_map(point);

                    }
                });

                try {
                    // Customise the styling of the base map using a JSON object defined
                    // in a raw resource file.
                    boolean success = googleMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    getActivity(), R.raw.styled_map));

                    if (!success) {
                        Log.e(TAG, "Style parsing failed.");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e(TAG, "Can't find style. Error: ", e);
                }


                mapView.onResume();
            }
        });
    }












    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
