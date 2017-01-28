package app.pistachevegane.com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Recipes.db";
    public static final String RECIPES_TABLE_NAME = "recipes";
    public static final String RECIPES_COLUMN_ID = "id";
    public static final String RECIPES_COLUMN_TITLE = "title";
    public static final String RECIPES_COLUMN_TYPE = "type";
    public static final String RECIPES_COLUMN_LABELTIME = "labelTime";
    public static final String RECIPES_COLUMN_TIMETOCOOK = "timeToCook";
    public static final String RECIPES_COLUMN_COMPLEXITY = "complexity";
    public static final String RECIPES_COLUMN_IDRES = "identifierDrawablePicture";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table recipes " +
                        "(id integer primary key autoincrement, title text,type text,labelTime text, " +
                        "timeToCook integer,complexity text,identifierDrawablePicture integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(db);
    }
}
