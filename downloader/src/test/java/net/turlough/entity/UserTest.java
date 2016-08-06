package net.turlough.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by turlough on 06/08/16.
 */
public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getId() throws Exception {
        user.setId(3);
        assertEquals (3, user.getId());
    }

}