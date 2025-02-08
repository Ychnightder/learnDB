package db.learnDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper  {

    private Context context;
    private static final String name = "library.db";
    private static final int version = 1;
    private static final String BOOK_TABLE = "BOOK";
    private static final String COLUMN_ID = "COLUMN_ID";
    private static final String COLUMN_PAGES = "pages";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";

    public DatabaseManager(@Nullable Context context) {
        super(context, name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStmt = "CREATE TABLE " + BOOK_TABLE + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_TITLE + " TEXT NOT NULL, " + COLUMN_AUTHOR + " TEXT NOT NULL, " + COLUMN_PAGES + " INTEGER NOT NULL)";
        db.execSQL(createTableStmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
        onCreate(db);
    }

    void addBook(String title, String author, int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_AUTHOR, author);
        cv.put(COLUMN_PAGES, pages);
       long result = db.insert(BOOK_TABLE, null, cv);
        if(result == -1){
            Toast.makeText(context, "fail to add book", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "book added", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
