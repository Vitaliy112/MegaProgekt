package com.solonenko.vitaliy.megaprogekt123;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by vitaliy on 20.01.2017.
 */

public class Locacthinservisy  extends Service{

    private LocationManager locationManager;

    private static final String TAG = "Locacthinservisy";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressWarnings("MissingPermission")
    @Override
    public void onCreate() {

        super.onCreate();

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000 * 10, 1,
                locationListener);
        locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 1000 * 10, 1,
                locationListener);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
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
