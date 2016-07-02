package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utility.DateUtil;
import utility.Item;

public class ItemDBHelper extends SQLiteOpenHelper implements ModelInterface.DB {

    public static final String DATABASE_NAME = "itemdatabase.db";
    private static final int DATABASE_VERSION = 6;
    public static final String ITEM_TABLE_NAME = "itemtable1";
    public static final String ITEM_ID= "_id";
    public static final String ITEM_TITLE = "title";
    public static final String ITEM_DESC = "desc";
    public static final String ITEM_COLOUR = "colour";
    public static final String ITEM_DATE = "date";


    public ItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + ITEM_TABLE_NAME + "( " +
                ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ITEM_TITLE + " TEXT, " +
                ITEM_DESC + " TEXT, " +
                ITEM_COLOUR + " INTEGER, " +
                ITEM_DATE + " DATE " +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + ITEM_TABLE_NAME);
        onCreate(db);
    }

    @Override
    public List<Item> getData() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(ITEM_TABLE_NAME,
                new String[]{ITEM_TITLE, ITEM_DESC, ITEM_COLOUR, ITEM_DATE},
                null, null, null, null, null);

        ArrayList<Item> itemList = new ArrayList<>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            itemList.add(readCursor(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return itemList;
    }

    @Override
    public void addItem(String title, String desc, int colour) {
        ContentValues values = new ContentValues();
        values.put(ITEM_TITLE, title);
        values.put(ITEM_DESC,desc);
        values.put(ITEM_COLOUR, colour);
        values.put(ITEM_DATE, DateUtil.getDate());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ITEM_TABLE_NAME, null, values);
    }

    @Override
    public void deleteItem(int position) {
        SQLiteDatabase db = getWritableDatabase();
        List<Integer> idList = getIdList();
        int itemId = idList.get(position);
        db.delete(ITEM_TABLE_NAME, ITEM_ID + "=" + itemId, null);
    }

    @Override
    public Item getItem(int position) {
        SQLiteDatabase db = getWritableDatabase();
        List<Integer> idList = getIdList();
        int itemId = idList.get(position);
        Cursor cursor = db.query(ITEM_TABLE_NAME,
                new String[]{ITEM_TITLE, ITEM_DESC, ITEM_COLOUR, ITEM_DATE},
                ITEM_ID + "=" + itemId, null, null, null, null);
        cursor.moveToFirst();
        return readCursor(cursor);
    }

    public Item readCursor(Cursor cursor){
        String title = cursor.getString(cursor.getColumnIndexOrThrow(ITEM_TITLE));
        String desc = cursor.getString(cursor.getColumnIndexOrThrow(ITEM_DESC));
        int colour = cursor.getInt(cursor.getColumnIndexOrThrow(ITEM_COLOUR));
        String date = cursor.getString(cursor.getColumnIndex(ITEM_DATE));
        return new Item(title,desc,colour,date);
    }

    public List<Integer> getIdList(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(ITEM_TABLE_NAME,
                new String[]{ITEM_ID},
                null, null, null, null, null);

        ArrayList<Integer> idList = new ArrayList<>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(ITEM_ID));
            idList.add(id);
            cursor.moveToNext();
        }
        cursor.close();

        return idList;
    }
}
