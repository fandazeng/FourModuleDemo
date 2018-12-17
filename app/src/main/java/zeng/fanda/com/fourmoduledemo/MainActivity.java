package zeng.fanda.com.fourmoduledemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zeng.fanda.com.fourmoduledemo.activity.LifeFirstActivity;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv_navigation)
    TextView mNavigation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d("onCreate" + "===" +TAG);
        ButterKnife.bind(this);
        //如果不是因为异常情况导致重新创建，则为Null
        if (savedInstanceState != null) {
            mNavigation.setText(savedInstanceState.getString("key"));
        }
    }

    @OnClick({R.id.tv_navigation})
    public void onClick(View view){
            switch (view.getId()){
                case R.id.tv_navigation:
                    Intent intent = new Intent();
                    intent.setAction("abc");
//                    intent.setType("image/*");
                    intent.setDataAndType(Uri.parse("content://abc"), "image/jpg");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
//                    startActivity(new Intent(this,LifeFirstActivity.class));
                    break;
                default:
                    break;
            }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.d("onStart"+ "===" +TAG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.d("onRestart"+ "===" +TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.d("onResume"+ "===" +TAG);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.d("onPause"+ "===" +TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.d("onStop"+ "===" +TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("onDestroy"+ "===" +TAG);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key","恢复数据");
        Logger.d("onSaveInstanceState"+ "===" +TAG);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Logger.d("onRestoreInstanceState"+ "===" +TAG);
//        mNavigation.setText(savedInstanceState.getString("key")+ "===" +TAG);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //横屏2,竖屏1
        Logger.d("onConfigurationChanged"+ newConfig.orientation + "===" +TAG);
    }
}
