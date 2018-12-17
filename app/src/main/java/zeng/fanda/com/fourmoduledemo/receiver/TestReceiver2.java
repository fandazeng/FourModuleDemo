package zeng.fanda.com.fourmoduledemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

/**
 * @author 曾凡达
 * @date 2018/12/5
 */
public class TestReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.i(getResultData());
        Logger.i("TestReceiver-2");
        setResultData("我是广播二");
    }

}
