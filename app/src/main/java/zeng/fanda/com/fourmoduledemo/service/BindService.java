package zeng.fanda.com.fourmoduledemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

/**
 * @author 曾凡达
 * @date 2018/12/4
 */
public class BindService extends Service {

    protected final String TAG = this.getClass().getSimpleName();

    private MyBinder mBinder = new MyBinder();

    public class MyBinder extends Binder {

        @Override
        public String toString() {
            return "this is mybinder";
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.i(" onBind: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());

        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i(" onCreate: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.i(" onStartCommand: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.i(" onUnbind: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i(" onDestroy: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());

    }
}
