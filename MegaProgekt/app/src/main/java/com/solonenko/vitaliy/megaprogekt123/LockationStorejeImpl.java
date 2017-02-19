package com.solonenko.vitaliy.megaprogekt123;

import android.location.Location;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class LockationStorejeImpl implements LockationStoraje {

    private static final String TAG = "LockationStoregImp";

    private List<Location> locations ;

    public LockationStorejeImpl() {
  locations = new ArrayList<>();

    }


    @Override
    public void addLockation(@NonNull Location location) {
        locations.add(location);
        Log.d(TAG, "addLockation() called with: location = [" + location + "]");

    }



    @Override
    public List<Location> getLockation() {

        return locations;
    }
}
