package sdx.mydb;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
        Button createDB = (Button) findViewById(R.id.create_db_buttion);
        createDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getReadableDatabase();
            }
        });
        Button addData = (Button)findViewById(R.id.add_data_buttion);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sdb = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","第一行代码");
                values.put("author","是东线");
                values.put("pages",100);
                values.put("price",35.6);
                sdb.insert("book",null,values);
                values.clear();
                values.put("name","唱歌性");
                values.put("author","武则天");
                values.put("pages",101);
                values.put("price",99.5);
                sdb.insert("book",null,values);

            }
        });


        Button updateData = (Button)findViewById(R.id.update_data_buttion);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sdb = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("author","毛泽东");
                sdb.update("Book",values,"name=?",new String[]{"第一行代码"});

            }
        });

        Button deleteData = (Button)findViewById(R.id.delete_data_buttion);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sdb = dbHelper.getWritableDatabase();
                sdb.delete("Book","pages>?",new String[]{"100"});

            }
        });

        Button queryData = (Button)findViewById(R.id.query_data_buttion);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sdb = dbHelper.getWritableDatabase();
                sdb.delete("Book","pages>?",new String[]{"100"});

            }
        });

    }
}
