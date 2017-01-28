package app.pistachevegane.com.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.pistachevegane.com.db.DBHelper;
import app.pistachevegane.com.model.Recipe;

public class RecipesDataSource {
    // Database fields
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public RecipesDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertRecipe (Recipe recipe) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.RECIPES_COLUMN_TITLE, recipe.getTitle());
        contentValues.put(dbHelper.RECIPES_COLUMN_TYPE, recipe.getType());
        contentValues.put(dbHelper.RECIPES_COLUMN_LABELTIME, recipe.getLabelTime());
        contentValues.put(dbHelper.RECIPES_COLUMN_TIMETOCOOK, recipe.getTimeToCook());
        contentValues.put(dbHelper.RECIPES_COLUMN_COMPLEXITY, recipe.getComplexity());
        contentValues.put(dbHelper.RECIPES_COLUMN_IDRES, recipe.getIdentifierDrawablePicture());
        db.insert("recipes", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery( "select * from contacts where id="+id+"", null );
    }

    public int numberOfRows(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, dbHelper.RECIPES_TABLE_NAME);
    }

    public boolean updateRecipe (Recipe recipe) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.RECIPES_COLUMN_TITLE, recipe.getTitle());
        contentValues.put(dbHelper.RECIPES_COLUMN_TYPE, recipe.getType());
        contentValues.put(dbHelper.RECIPES_COLUMN_LABELTIME, recipe.getLabelTime());
        contentValues.put(dbHelper.RECIPES_COLUMN_TIMETOCOOK, recipe.getTimeToCook());
        contentValues.put(dbHelper.RECIPES_COLUMN_COMPLEXITY, recipe.getComplexity());
        contentValues.put(dbHelper.RECIPES_COLUMN_IDRES, recipe.getIdentifierDrawablePicture());
        db.update("recipes", contentValues, "id = ? ", new String[] { Long.toString(recipe.getId()) } );
        return true;
    }

    public Integer deleteRecipe (Integer id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete("recipes",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();

        //hp = new HashMap();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from recipes", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            Recipe recipe = new Recipe();
            recipe.setId(res.getLong(0));
            recipe.setTitle(res.getString(1));
            recipe.setType(res.getString(2));
            recipe.setLabelTime(res.getString(3));
            recipe.setComplexity(res.getString(4));
            recipe.setIdentifierDrawablePicture(res.getInt(5));
            recipes.add(recipe);
            res.moveToNext();
        }

        res.close();
        return recipes;
    }
}
