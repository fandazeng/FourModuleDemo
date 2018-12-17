package zeng.fanda.com.fourmoduledemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

/**
 * @author 曾凡达
 * @date 2018/12/3
 */
public class TestIntentService extends IntentService {

    protected final String TAG = this.getClass().getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public TestIntentService( ) {
        super("TestIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i(" onCreate: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Logger.i(" onHandleIntent: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());
        try {
            Thread.sleep(26000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i(" onDestroy: " + TAG + " === " + " ThreadId: "+ Thread.currentThread().getId()+ " === " +" hasCode: " + hashCode());

    }
}
