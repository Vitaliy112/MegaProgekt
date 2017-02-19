package com.solonenko.vitaliy.megaprogekt123;

import android.location.Location;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class LockationStorejeImpl implements LockationStoraje {

    private static final String TAG = "LockationStoregImp";
     private AbdeitListener abdeitListener;
    private List<Location> locations ;

    public LockationStorejeImpl() {
  locations = new ArrayList<>();

    }


    @Override
    public void setListener(@NonNull AbdeitListener listener) {
        abdeitListener = listener;

    }

    @Override
    public void addLockation(@NonNull Location location) {
        locations.add(location);
        abdeitListener.onLockationChenged(locations);
        Log.d(TAG, "addLockation() called with: location = [" + location + "]");

    }



    @Override
    public List<Location> getLockation() {

        return locations;
    }
}
