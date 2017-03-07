package techprosolution.chatdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import techprosolution.chatdemo.dao.DaoMaster;
import techprosolution.chatdemo.dao.DaoSession;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class DBManager
{

    private static DaoSession daoSessionMain;
    private static DaoMaster.DevOpenHelper helperInstance;

    public static final String DB_NAME = "chat_database";

    private DBManager()  {
    }

    public static DaoSession getDaoSessionMain() {
        if (daoSessionMain == null) {
            throw new Error("DatabaseManager.init(context) not called");
        } else
            return daoSessionMain;
    }

    public static void init(Context context) {
        // init db
        if (helperInstance == null) {
            helperInstance = new DaoMaster.DevOpenHelper(context.getApplicationContext(), DB_NAME, null);
        }
        SQLiteDatabase db = helperInstance.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSessionMain = daoMaster.newSession();
    }

    /**
     * Closes any open DB Instance.
     */
    public static void closeDataBase() {
        if (helperInstance != null) {
            helperInstance.close();
        }
    }
}
