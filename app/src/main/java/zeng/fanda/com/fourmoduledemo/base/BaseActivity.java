package zeng.fanda.com.fourmoduledemo.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;

/**
 * @author 曾凡达
 * @date 2018/11/29
 */
public class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i(" onCreate: " + TAG + " === " + " TaskId: " + getTaskId() + " === " + " hasCode: " + hashCode());
        dumpTaskAffinity();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.i(" onNewIntent: " + TAG + " === " + " TaskId: " + " === " + getTaskId() + " hasCode: " + hashCode());
        dumpTaskAffinity();
    }

    private void dumpTaskAffinity() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Logger.i(" taskAffinity: " + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Logger.i(" onStart: " + TAG + " === " + " TaskId: " + getTaskId() + " === " + " hasCode: " + hashCode());
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Logger.i(" onResume: " + TAG + " === " + " TaskId: " + getTaskId() + " === " + " hasCode: " + hashCode());
//    }
}
