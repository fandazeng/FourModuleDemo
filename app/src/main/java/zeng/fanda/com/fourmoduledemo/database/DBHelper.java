package zeng.fanda.com.fourmoduledemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * @author 曾凡达
 * @date 2018/12/10
 */
public class DBHelper extends SQLiteOpenHelper {

    private static String name = "test.db";
    private static int version = 1;

    public DBHelper( Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 只能支持基本数据类型 ： varchar int long float boolean text blob
        String sql = "create table person(id integer primary key autoincrement,name varchar(64),address varchar(64))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "alter table person add sex varcher(8)";
        db.execSQL(sql);
    }
}
