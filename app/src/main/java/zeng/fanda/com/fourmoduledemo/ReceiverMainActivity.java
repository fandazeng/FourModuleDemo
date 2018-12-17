package zeng.fanda.com.fourmoduledemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;
import zeng.fanda.com.fourmoduledemo.receiver.NetworkChangeReceiver;
import zeng.fanda.com.fourmoduledemo.service.BindService;
import zeng.fanda.com.fourmoduledemo.service.TestIntentService;

/**
 * @author 曾凡达
 * @date 2018/12/3
 */
public class ReceiverMainActivity extends AppCompatActivity {

    private NetworkChangeReceiver mNetworkChangeReceiver;

    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_main);
        ButterKnife.bind(this);

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        initReceiver();

    }

    private void initReceiver() {
        mNetworkChangeReceiver = new NetworkChangeReceiver();
        //动态注册：创建一个IntentFilter的实例，添加网络变化的广播(功能是对组件进行过滤，只获取需要的消息)
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        mLocalBroadcastManager.registerReceiver(mNetworkChangeReceiver,intentFilter);
//        registerReceiver(mNetworkChangeReceiver, intentFilter);
    }

    @OnClick({R.id.tv_send_disorder_receiver, R.id.tv_send_order_receiver})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_send_disorder_receiver:
                mLocalBroadcastManager.sendBroadcast(new Intent("android.net.conn.CONNECTIVITY_CHANGE"));
//                sendBroadcast(new Intent("zeng.fanda.com.fourmoduledemo.test"));
                break;
            case R.id.tv_send_order_receiver:
                sendOrderedBroadcast(new Intent("zeng.fanda.com.fourmoduledemo.test"),null);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mNetworkChangeReceiver);
//        unregisterReceiver(mNetworkChangeReceiver);
    }
}
