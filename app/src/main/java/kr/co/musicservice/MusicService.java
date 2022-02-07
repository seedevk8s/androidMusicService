package kr.co.musicservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate()");

        mediaPlayer = MediaPlayer.create(this, R.raw.dbd);
        mediaPlayer.setLooping(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Music Service가 중지되었습니다.", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy()");
        mediaPlayer.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Music Service가 시작되었습니다.", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStartCommand()");
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }
}


























