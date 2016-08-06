package net.turlough.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import net.turlough.downloader.BuildConfig;
import net.turlough.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by turlough on 06/08/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class UserDbOpenHelperTest {

    UserDbOpenHelper helper;
    User user;
    Dao<User, Long> dao;

    @Before
    public void setUp() throws Exception {
        Context context = RuntimeEnvironment.application;
        helper = new UserDbOpenHelper(context);
        dao = helper.getDao();
        user = new User(){{
            setForename("forename");
            setSurname("surname");
        }};
    }

    @Test
    public void testNotNull() {
        assertNotNull(dao);
        assertEquals("forename", user.getForename());
    }

    @Test
    public void createAndThenQuery() throws Exception {
        dao.create(user);
        User result = dao.queryForSameId(user);
        assertEquals(user.getForename(), result.getForename());
    }

}