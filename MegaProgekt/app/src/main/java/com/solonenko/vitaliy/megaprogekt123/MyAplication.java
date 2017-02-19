package com.solonenko.vitaliy.megaprogekt123;

import android.app.Application;

/**
 * Created by vitaliy on 19.02.2017.
 */

public class MyAplication extends Application {

    private LockationStoraje lockationStoraje;

    @Override
    public void onCreate() {
        super.onCreate();

        lockationStoraje = new LockationStorejeImpl();
    }

    public LockationStoraje getLockationStoraje() {
        return lockationStoraje;
    }
}
