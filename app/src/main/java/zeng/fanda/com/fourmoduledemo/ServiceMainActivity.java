package zeng.fanda.com.fourmoduledemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.OnClick;
import zeng.fanda.com.fourmoduledemo.service.BindService;
import zeng.fanda.com.fourmoduledemo.service.TestIntentService;
import zeng.fanda.com.fourmoduledemo.service.TestService;

/**
 * @author 曾凡达
 * @date 2018/12/3
 */
public class ServiceMainActivity extends AppCompatActivity {

    private ServiceConnection mServiceConnection;
    private BindService.MyBinder mBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        ButterKnife.bind(this);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (BindService.MyBinder) service;
                Logger.i(" onServiceConnected: " + mBinder.toString());
                //服务连接成功
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                //与服务连接断连
            }
        };
    }

    @OnClick({R.id.tv_start_service, R.id.tv_stop_service, R.id.tv_start_intent_service, R.id.tv_bind_service, R.id.tv_unbind_service})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_start_service:
                startService(new Intent(this, BindService.class));
                break;
            case R.id.tv_start_intent_service:
                startService(new Intent(this, TestIntentService.class));
                break;
            case R.id.tv_stop_service:
                stopService(new Intent(this, BindService.class));
                break;
            case R.id.tv_bind_service:
                bindService(new Intent(this, BindService.class),mServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.tv_unbind_service:
                unbindService(mServiceConnection);
                break;
            default:
                break;
        }
    }
}
