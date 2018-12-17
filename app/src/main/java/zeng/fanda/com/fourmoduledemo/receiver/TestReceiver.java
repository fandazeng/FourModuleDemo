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
public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //测试 10s 内没执行完，会不会造成 ANR
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            i--;
//        }
//        abortBroadcast();
        setResultData("我是广播一");
        Logger.i("TestReceiver-1");
    }

}
