package zeng.fanda.com.fourmoduledemo;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.orhanobut.logger.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author 曾凡达
 * @date 2018/12/11
 */
@RunWith(AndroidJUnit4.class)
public class ProviderTest  {

    @Test
    public void callTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        ContentResolver resolver = appContext.getContentResolver();
        Uri uri = Uri.parse("content://zeng.fanda.com.fourmoduledemo.provider.PersonProvider/person");
        Bundle bundle = resolver.call(uri, "method", null, null);
        Logger.d("callTest: "+bundle.getString("returnCall"));
    }

}
