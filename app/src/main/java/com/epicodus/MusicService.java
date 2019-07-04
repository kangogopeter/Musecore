package com.epicodus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MusicService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
