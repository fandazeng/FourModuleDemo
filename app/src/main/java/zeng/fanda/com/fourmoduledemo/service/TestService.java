package zeng.fanda.com.fourmoduledemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

/**
 * @author 曾凡达
 * @date 2018/12/3
 */
public class TestService extends Service {

    protected final String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i(" onCreate: " + TAG + " === " + " hasCode: " + hashCode());
        try {
            Thread.sleep(260000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.i(" onStartCommand: " + TAG + " === " + " flags: " + flags + " === " + " hasCode: " + hashCode());
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i(" onDestroy: " + TAG + " === " + " hasCode: " + hashCode());

    }
}
