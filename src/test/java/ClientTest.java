import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sfedu.Client;
import ru.sfedu.lab3CSV.DataProviderCSV;
import ru.sfedu.lab3CSV.Users;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ClientTest {


    private static final Logger log = LogManager.getLogger(DataProviderCSV.class.getName());
    DataProviderCSV dpc = new DataProviderCSV();


    @Test
    public void testUsersSelect(){
        List<Users> users = dpc.selectUsers();
        for (Users e : users) {
            log.info(e.getUserName());
            log.info(e.getUserId());
        }
    }

    @Test
    public void testUsersGetById(){
        Users users = dpc.getById(1);
        Assertions.assertEquals("Klara", users.getUserName());
        testUsersSelect();
        }

    @Test
    public void testUsersInsert() {
        Users users = new Users(3,"Rob","1-855-835-7621","non@Lorem.edu");
        dpc.insertUsers(users);
        testUsersSelect();
        dpc.deleteUsersById(2);

    }

    @Test
    public void testUsersUpdate() {
        Users users = new Users(3,"Rob","1-855-835-7621","non@Lorem.edu");
        dpc.insertUsers(users);
        testUsersSelect();
        Users users_2 = new Users(2,"Sam","1-855-835-7621","non@Lorem.edu");
        dpc.updateUsersById(3, users_2);
        testUsersSelect();
        dpc.deleteUsersById(2);
    }

    @Test
    public void testUsersDelete() {
        //Users users = new Users(3,"Sam","1-855-835-7621","non@Lorem.edu");
        //dpc.insertUsers(users);
        //testUsersSelect();
        dpc.deleteUsersById(3);
        dpc.deleteUsersById(2);
        testUsersSelect();
    }

    @Test
    void Client() {
        try {
            Client.main(new String[]{""});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}