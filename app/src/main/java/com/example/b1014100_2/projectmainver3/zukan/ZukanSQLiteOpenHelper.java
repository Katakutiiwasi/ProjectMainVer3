package com.example.b1014100_2.projectmainver3.zukan;

/**
 * Created by b1014159
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLiteOpenHelperのサブクラスSampleSQLiteOpenHelperの実装
 */
class ZukanSQLiteOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "noadd_zukans.db";
    static final String TABLE_NAME = "fish";
    static final int DB_VERSION = 1;

    static final String CREATE_TABLE = "create table " + TABLE_NAME + "( " +
            "_id integer primary key not null, " +
            "name text, " +
            "content text, " +
            "type text, " +
            "length integer, " +
            "season text, " +
            "image_name text);";

    static final String DROP_TABLE = "drop table " + TABLE_NAME + ";";

    public ZukanSQLiteOpenHelper(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    /**
     * データベースファイル初回使用時に実行される処理
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成のクエリを発行
        db.execSQL(CREATE_TABLE);
    }

    /**
     * データベースのバージョンアップ時に実行される処理
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // テーブルの破棄と再作成
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}