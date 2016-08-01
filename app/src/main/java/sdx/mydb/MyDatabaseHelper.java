package sdx.mydb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by lsx on 2016/7/31.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    /* 创建book表*/
    public static  final String Create_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";
    public static  final  String Create_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";
    private Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_BOOK);
        db.execSQL(Create_CATEGORY);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
    /**
     * 删除数据库
     *
     * @param context
     * @return
     */
    public boolean deleteDatabase(Context context,String name) {
        return context.deleteDatabase(name);
    }
}
