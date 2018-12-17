package zeng.fanda.com.fourmoduledemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author 曾凡达
 * @date 2018/12/10
 */
public class PersonDao {

    private DBHelper mDBHelper;

    public PersonDao(Context context) {
        mDBHelper = new DBHelper(context);
    }

    public long insertPserson(ContentValues values) {
        long id = -1;
        SQLiteDatabase database = null;
        try {
            database = mDBHelper.getWritableDatabase();
            id = database.insert("person", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return id;
    }

    public int deletePerson(String whereClause, String[] whereArgs) {
        int count = -1;
        SQLiteDatabase database = null;
        try {
            database = mDBHelper.getWritableDatabase();
            count = database.delete("person", whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return count;
    }

    public int updatePerson(ContentValues values, String whereClause, String[] whereArgs) {
        int count = -1;
        SQLiteDatabase database = null;
        try {
            database = mDBHelper.getWritableDatabase();
            count = database.update("person",values, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return count;
    }

    public Cursor queryPersons(String selection, String[] selectionArgs) {
        SQLiteDatabase database = null;
        Cursor cursor = null;
        try {
            // 这里获取读数据库
            database = mDBHelper.getReadableDatabase();
            cursor = database.query(true, "person", null, selection, selectionArgs, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return cursor;
    }
}
