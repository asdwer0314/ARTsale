package ru.sfedu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;


public class ConfigurationUtil {
//    private static final Logger log = LogManager.getLogger(ConfigurationUtil.class.getName());

    private static final String DEFAULT_CONFIG_PATH ="./src/main/resources/environment.properties";
    private static final Properties CONFIGURATION = new Properties();

    /**
     * Hides default constructor
     */
    public ConfigurationUtil() {}

    private static Properties getConfiguration() throws IOException {
        if(CONFIGURATION.isEmpty()){
            loadConfiguration();
        }
        return CONFIGURATION;
    }

    /**
     * Loads configuration from <code>DEFAULT_CONFIG_PATH</code>
     * @throws IOException In case of the configuration file read failure
     */
    private static void loadConfiguration() throws IOException{
        File nf;
        if (System.getProperty(Constants.CONFIG_PATH) != null) {

            nf = new File(System.getProperty(Constants.CONFIG_PATH));
        } else {
            nf = new File(DEFAULT_CONFIG_PATH);
        }
//        File nf = new File(DEFAULT_CONFIG_PATH);
        InputStream in = new FileInputStream(nf);
//      DEFAULT_CONFIG_PATH.getClass().getResourceAsStream(DEFAULT_CONFIG_PATH);

        try {
            CONFIGURATION.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally{
            in.close();
        }
    }


    /**
     * Gets configuration entry value
     * @param key Entry key
     * @return Entry value by key
     * @throws IOException In case of the configuration file read failure
     */
    public static String getConfigurationEntry(String key) throws IOException{
        return getConfiguration().getProperty(key);
    }

}