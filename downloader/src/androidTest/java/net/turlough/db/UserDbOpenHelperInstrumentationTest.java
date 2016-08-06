package net.turlough.db;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.j256.ormlite.dao.Dao;

import net.turlough.entity.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by turlough on 06/08/16.
 */
@RunWith(AndroidJUnit4.class)
public class UserDbOpenHelperInstrumentationTest {

    UserDbOpenHelper helper;
    User user;
    Dao<User, Long> dao;

    @Before
    public void setUp() throws Exception {

        Context context = InstrumentationRegistry.getContext();
        helper = new UserDbOpenHelper(context);
        dao = helper.getDao();
        user = new User(){{
            setForename("forename");
            setSurname("surname");
        }};

    }

    @After
    public void tearDown() throws Exception {
        dao.delete(dao.queryForAll());

    }

    @Test
    public void isSetupCorrectly() {
        assertNotNull(dao);
        assertEquals("forename", user.getForename());
    }

    @Test
    public void createOneUserAndThenQuery() throws Exception {
        dao.create(user);
        User result = dao.queryForSameId(user);
        assertEquals(user.getForename(), result.getForename());
    }

    @Test
    public void addMultipleUsers() throws Exception {

        dao.create(new User("test1", "surname"));
        dao.create(new User("test2", "surname"));
        assertEquals(2, dao.countOf());
    }
}