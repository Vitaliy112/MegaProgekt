package com.solonenko.vitaliy.megaprogekt123;

import android.location.Location;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by vitaliy on 19.02.2017.
 */

public interface LockationStoraje {
    void addLockation(@NonNull Location location);

    List<Location> getLockation();

}

