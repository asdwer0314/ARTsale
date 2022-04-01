package ru.sfedu.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderCSVTest {

    @BeforeEach
    void setUp() {
    }

    private static final Logger log = LogManager.getLogger(DataProviderCSV.class.getName());
    DataProviderCSV dpc = new DataProviderCSV();

    @Test
    public void testCSVSelect() {
        List<User> user = dpc.selectUser();
        for (User e : user) {
            log.info(e.getUserId()+"    "+e.getUserName());
        }
    }

    @Test
    public void testCSVGetById() {
        User users = dpc.getUserById(1);
        Assertions.assertEquals("Klara", users.getUserName());
//        testCSVSelect();
    }

    @Test
    public void testCSVInsertPos() {
        User user = new User(2, "Rob", "1-855-835-7621", "non@Lorem.edu");
        dpc.insertUser(user);
        Assertions.assertEquals(user, dpc.getUserById(user.getUserId()));
//        testCSVSelect();
        dpc.deleteUserById(user.getUserId());
    }

    @Test
    public void testCSVInsertNeg() {
        User user = new User(3, "Rob", "1-855-835-7621", "non@Lorem.edu");
        dpc.insertUser(user);
        Assertions.assertNotEquals(new User(), dpc.getUserById(user.getUserId()));
//      testCSVSelect();
        dpc.deleteUserById(user.getUserId());
    }

    @Test
    public void testCSVUpdate() {
        User user = new User(3, "Rob", "1-855-835-7621", "non@Lorem.edu");
        dpc.insertUser(user);
        User users_2 = new User(2, "Sam", "1-855-835-7621", "non@Lorem.edu");
        dpc.updateUserById(3, users_2);
        Assertions.assertNotEquals(new User(), dpc.getUserById(user.getUserId()));
//      testCSVSelect();
    }

    @Test
    public void testCSVDelete() {
        User user = new User(4, "Sam", "1-855-835-7621", "non@Lorem.edu");
        dpc.insertUser(user);
        testCSVSelect();
        log.info("запись добавлена");

        dpc.deleteUserById(2);
        dpc.deleteUserById(4);
        testCSVSelect();
        log.info("запись добавлена");
    }
    @AfterEach
    void tearDown() {
    }
}