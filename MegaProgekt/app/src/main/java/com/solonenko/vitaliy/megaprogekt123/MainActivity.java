package com.solonenko.vitaliy.megaprogekt123;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LocationManager locationManager;
    StringBuilder sbGPS = new StringBuilder();
    StringBuilder sbNet = new StringBuilder();
    private static final String TAG = "MainActivity";

    private static final int REQUEST_PERMISSION_LOCATION = 201;

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
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION_LOCATION);



        }else {
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

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Get read location permission", Toast.LENGTH_LONG).show();
                finish();
            } else {
                onPermissionResiv();
            }

        }
    }

    private void onPermissionResiv() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Toast.makeText(this, "Permission grandet", Toast.LENGTH_SHORT).show();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000 * 10, 10, locationListener);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000 * 10, 1,
                locationListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {
            //   showLocation(location);
            Log.d(TAG, "onLocationChanged() called with: location = [" + location + "]");
        }

        @Override
        public void onProviderDisabled(String provider) {
            // checkEnabled();
            Log.d(TAG, "onProviderDisabled() called with: provider = [" + provider + "]");
        }

        @Override
        public void onProviderEnabled(String provider) {
            // checkEnabled();
            // showLocation(locationManager.getLastKnownLocation(provider));
            Log.d(TAG, "onProviderEnabled() called with: provider = [" + provider + "]");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            if (provider.equals(LocationManager.GPS_PROVIDER)) {
                //  tvStatusGPS.setText("Status: " + String.valueOf(status));
                //  } else if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
                // tvStatusNet.setText("Status: " + String.valueOf(status));
                Log.d(TAG, "onStatusChanged() called with: provider = [" + provider + "], status = [" + status + "], extras = [" + extras + "]");
            }
        }
    };

}
