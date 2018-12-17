package zeng.fanda.com.fourmoduledemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.orhanobut.logger.Logger;

/**
 * @author 曾凡达
 * @date 2018/12/5
 */
public class TestReceiver3 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.i(getResultData());
        Logger.i("TestReceiver-3");
    }

}
