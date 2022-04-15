package com.ecommerce.hashtagcollection.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.cardview.widget.CardView;

import com.ecommerce.hashtagcollection.model.TestCartModel;

import java.util.ArrayList;
import java.util.List;

public class SqliteDBHandler extends SQLiteOpenHelper {

    private final static String DB_NAME = "HashTagCollection";
    private final static int DB_VERSION = 1;

    //Table CART
    private final String CART_TBL = "CART";
    private final String CART_ID = "ID";
    private final String PRODUCT_TITLE = "PRODUCT_TITLE";
    private final String PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";
    private final String PRODUCT_ITEM = "PRODUCT_ITEM";
    private final String PRODUCT_PRICE = "PRODUCT_PRICE";
    private final String PRODUCT_IMAGE= "PRODUCT_IMAGE";

    public SqliteDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+CART_TBL+ " ( "
                +CART_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PRODUCT_TITLE+ " TEXT NOT NULL, "
                +PRODUCT_DESCRIPTION + "TEXT NOT NULL, "
                +PRODUCT_ITEM+ "INTEGER NOT NULL, "
                +PRODUCT_PRICE+ "INTEGER NOT NULL, "
                +PRODUCT_IMAGE+ "INTEGER NOT NULL )";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "DROP TABLE IF EXISTS "+ CART_TBL;
        db.execSQL(dropTable);
        onCreate(db);
    }

    public long insertIntoCart(TestCartModel cartModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_TITLE, cartModel.getProductTitle());
        contentValues.put(PRODUCT_DESCRIPTION, cartModel.getProductDesc());
        contentValues.put(PRODUCT_PRICE, cartModel.getProductPrice());
        contentValues.put(PRODUCT_TITLE, cartModel.getProductItems());
        contentValues.put(PRODUCT_IMAGE, cartModel.getProductImage());

        long id = db.insert(CART_TBL,null, contentValues);
        db.close();
        return id;
    }

    public List<TestCartModel> retrieveAllCart() {
        List<TestCartModel> testCartModels = new ArrayList<TestCartModel>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+CART_TBL, null);

        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            testCartModels.add(new TestCartModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5))));
        }
        db.close();
        return testCartModels;

    }

    public void updateCart(TestCartModel cartModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUCT_TITLE, cartModel.getProductTitle());
        values.put(PRODUCT_DESCRIPTION, cartModel.getProductDesc());
        values.put(PRODUCT_ITEM, cartModel.getProductItems());
        values.put(PRODUCT_PRICE, cartModel.getProductPrice());
        values.put(PRODUCT_IMAGE, cartModel.getProductImage());
        db.update(CART_TBL, values, CART_ID + " = ?", new String[]{String.valueOf(cartModel.getProductId())});
        db.close();
    }

    public void deleteCart(TestCartModel cartModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CART_TBL,  CART_ID+ " = ?",
                new String[] { String.valueOf(cartModel.getProductId()) });
        db.close();
    }

    public TestCartModel getCartModel(long id) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery( "select * from " + CART_TBL +" where id="+id+"", null );
            res.moveToFirst();
            res.moveToNext();
            return new TestCartModel(Integer.parseInt(res.getString(0)),res.getString(1),res.getString(2),Integer.parseInt(res.getString(3)),Integer.parseInt(res.getString(4)),Integer.parseInt(res.getString(5)));
    }


}
