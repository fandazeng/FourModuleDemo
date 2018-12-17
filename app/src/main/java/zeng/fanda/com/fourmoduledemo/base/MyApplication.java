package zeng.fanda.com.fourmoduledemo.base;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;


/**
 * @author 曾凡达
 * @date 2018/11/27
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .methodOffset(7)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
