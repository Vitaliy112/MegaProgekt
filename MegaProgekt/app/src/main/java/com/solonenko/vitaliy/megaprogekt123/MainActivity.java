package com.solonenko.vitaliy.megaprogekt123;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";

    private static final int REQUEST_PERMISSION_LOCATION = 201;
    SupportMapFragment mapFragment;
    GoogleMap map;
    Marker marker;


    private boolean isTrackingNow;
    private FloatingActionButton floatingActionButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isPermissenGranted()) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION_LOCATION);


        } else {
            onPermissionResiv();

        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.btnStart);
        floatingActionButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        isTrackingNow = !isTrackingNow;
        floatingActionButton.setImageResource(isTrackingNow ? R.drawable.ic_stop_white_24dp : R.drawable.ic_play_arrow_white_24dp);
        Toast.makeText(this, "Button presed", Toast.LENGTH_SHORT).show();
        // map.addMarker(new MarkerOptions().position(new LatLng(0,0)).title(" Hello "));
        if (isPermissenGranted()) {
            Intent intent = new Intent(this, Locacthinservisy.class);
            startService(intent);
            Log.d(TAG, "onClick: ");
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (!isPermissenGranted()) {
                Toast.makeText(this, "Get read location permission", Toast.LENGTH_LONG).show();
                finish();
            } else {
                onPermissionResiv();
            }

        }
    }

    private void onPermissionResiv() {

        if (!isPermissenGranted()) {
            // TODO: Consider calling
//                ActivityCompat#requestPermissions
//             here to request the missing permissions, and then overriding
//               public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                                      int[] grantResults)
//             to handle the case where the user grants the permission. See the documentation
//             for ActivityCompat#requestPermissions for more details.
            return;
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @SuppressWarnings("MissingPermission")
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMyLocationEnabled(true);
            }
        });
    }

    public boolean isPermissenGranted() {

        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;


    }


}
