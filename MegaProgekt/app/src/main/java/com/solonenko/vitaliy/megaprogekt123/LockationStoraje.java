package com.solonenko.vitaliy.megaprogekt123;

import android.location.Location;
import android.support.annotation.NonNull;

import java.util.List;


public interface LockationStoraje {

    void setListener( @NonNull AbdeitListener listener);

    void addLockation(@NonNull Location location);

    List<Location> getLockation();


    interface AbdeitListener {

        void onLockationChenged(List<Location> locations);


    }


}



