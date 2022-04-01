
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sfedu.Client;
import ru.sfedu.api.DataProviderCSV;
import ru.sfedu.model.User;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ClientTest {



    @Test
    void Client() {
        try {
            Client.main(new String[]{""});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
