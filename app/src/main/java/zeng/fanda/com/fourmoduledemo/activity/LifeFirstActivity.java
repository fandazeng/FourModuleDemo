package zeng.fanda.com.fourmoduledemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.orhanobut.logger.Logger;

import zeng.fanda.com.fourmoduledemo.R;

/**
 * @author 曾凡达
 * @date 2018/11/27
 */
public class LifeFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Logger.d("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_first);
    }

    @Override
    protected void onStart() {
        Logger.d("onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Logger.d("onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Logger.d("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Logger.d("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Logger.d("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Logger.d("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Logger.d("onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Logger.d("onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Logger.d("onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }
}
