package com.royal.firebaseimplementation;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Myservice extends Service {
    @Nullable
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.mysong);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
