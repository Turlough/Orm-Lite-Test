package net.turlough.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import net.turlough.downloader.R;
import net.turlough.entity.User;

import java.sql.SQLException;

/**
 * Created by turlough on 06/08/16.
 */

public class UserDbOpenHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "todo";
    private static final int DATABASE_VERSION = 1;

    private Dao<User, Long> userDao;

    /**
     * R.raw.ormlite_config is a reference to the ormlite_config.txt file in the
     * /res/raw/ directory of this project
     * */
    public UserDbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, User.class, false);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an instance of the data access object
     * @return
     * @throws SQLException
     */
    public Dao<User, Long> getDao() throws SQLException {
        if(userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }
}
