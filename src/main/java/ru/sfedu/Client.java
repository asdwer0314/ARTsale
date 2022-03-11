package ru.sfedu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.lab3CSV.DataProviderCSV;
import ru.sfedu.lab3CSV.Users;
import utils.ConfigurationUtil;

import java.io.IOException;
import java.util.List;

public class Client {

    private static final Logger log = LogManager.getLogger(Client.class.getName());

    public static void main( String[] args ) throws IOException {

        DataProviderCSV dpc = new DataProviderCSV();
        Users us1 = new Users(4,"Max",
                "1-991-562-9420","tjoesis@Crasvulputate.com");
        Users us2 = new Users(2,"Klara",
                "1-855-835-7621","non@Lorem.edu");
        dpc.insertUsers(us1);
        dpc.insertUsers(us2);
        List<Users> profiles = dpc.selectUsers();
        /*Users Users = dpc.getById(1);
         System.out.println(Users.getMobNum());
         print details of Bean object
         for (Users e : profiles) {
         log.info(e.getUserName());
         }**/

        log.debug("Project starting application.......");
        log.info(ConfigurationUtil.getConfigurationEntry("j"));
        log.info(ConfigurationUtil.getConfigurationEntry("a"));
        log.info(System.getProperty("config.path"));

    }

    private void logBasicSystemInfo() {

        log.info("Launching the application...");
        log.info("Operating System: " +
                System.getProperty("os.name") + " "
                + System.getProperty("os.version"));
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }


}
