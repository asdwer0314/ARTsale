package ru.sfedu.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.utils.ConfigurationUtil;

import java.io.IOException;

public class LogTest {

    private static final Logger log = null;

//    @BeforeClass
//    public static void setLog() {
//        System.setProperty("log4j2.configurationFile", "log4j2.properties");
//        log = LogManager.getLogger();
//    }

    @Test
    public void logBasicSystemInfo() throws IOException {
        log.info("Launching the application...");
        log.info(
                "Operating System: " + System.getProperty("os.name") + " "
                        + System.getProperty("os.version")
        );
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");

        log.debug("Project starting application.......");
        log.info(ConfigurationUtil.getConfigurationEntry("j"));
        log.info(ConfigurationUtil.getConfigurationEntry("a"));
        log.info(System.getProperty("config.path"));
    }

}
