package zeng.fanda.com.fourmoduledemo.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;

import zeng.fanda.com.fourmoduledemo.database.PersonDao;

/**
 * @author 曾凡达
 * @date 2018/12/10
 */
public class PersonProvider extends ContentProvider {

    private final String TAG = "PersonProvider: ";
    private PersonDao mPersonDao;
    private final static String AUTHORITY = "zeng.fanda.com.fourmoduledemo.provider.PersonProvider";
    private final static UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    // 操作单行记录
    private static final int PERSON = 1;
    // 操作多行记录
    private static final int PERSONS = 2;

    static {
        URI_MATCHER.addURI(AUTHORITY, "person", PERSONS);
        URI_MATCHER.addURI(AUTHORITY, "person/#", PERSON);
    }

    @Override
    public boolean onCreate() {
        mPersonDao = new PersonDao(getContext());
        Logger.i(TAG + "onCreate");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case PERSON:
                long id = ContentUris.parseId(uri);
                cursor = mPersonDao.queryPersons("id = ?", new String[]{String.valueOf(id)});
                break;
            case PERSONS:
                cursor = mPersonDao.queryPersons(selection, selectionArgs);
                break;
        }
        if (cursor != null) {
            Logger.i(TAG + "--》查询成功,count = " + cursor.getCount());
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case PERSON:
                return "vnd.android.cursor.item/person";
            case PERSONS:
                return "vnd.android.cursor.dir/persons";       
        }
        return null;
    }


    @Nullable
    @Override
    public Uri insert(Uri uri, @Nullable ContentValues values) {
        Uri resultUri = null;
        // 解析Uri ，返回Code
        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case PERSONS:
                // 执行插入操作，返回当前的行号
                long id = mPersonDao.insertPserson(values);
                resultUri = ContentUris.withAppendedId(uri, id);
                Logger.i(TAG + "--》插入成功,id = " + id);
                Logger.i(TAG + "--》插入成功,resultUri = " + resultUri.toString());
        }
        return resultUri;
    }

    @Override
    public int delete(Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = -1; //影响数据库的行数
        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case PERSON:
                // 单条数据，使用 ContentUris 工具类解析出结尾的 Id
                long id = ContentUris.parseId(uri);
                count = mPersonDao.deletePerson("id = ?", new String[]{String.valueOf(id)});
                break;
            case PERSONS:
                count = mPersonDao.deletePerson(selection, selectionArgs);
                break;
        }
        Logger.i(TAG + "--》删除成功,count = " + count);
        return count;
    }

    @Override
    public int update(Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = -1;
        int flag = URI_MATCHER.match(uri);
        switch (flag) {
            case PERSON:
                long id = ContentUris.parseId(uri);
                count = mPersonDao.updatePerson(values, "id = ?", new String[]{String.valueOf(id)});
                break;
            case PERSONS:
                count = mPersonDao.updatePerson(values, selection, selectionArgs);
                break;
        }
        Logger.i(TAG + "--》更新成功,count = " + count);
        return count;
    }

    
    @Nullable
    @Override
    public Bundle call( @NonNull String method, @Nullable String arg,  @Nullable Bundle extras) {
        Bundle bundle = new Bundle();
        bundle.putString("returnCall","call被执行了");
        return bundle;
    }
}
