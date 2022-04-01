package ru.sfedu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.model.HistoryContent;

import static org.bson.Document.parse;
import static ru.sfedu.Constants.*;

public class HistoryUtil {
    private static final Logger log = LogManager.getLogger(HistoryUtil.class);

    public static void saveToLog(HistoryContent content) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_CNN)) {
            mongoClient.getDatabase(MONGO_DB).getCollection(MONGO_CLL).insertOne(parse(objectToString(content)));
        } catch (Exception e) {
            log.error(e);
        }
    }

    private static String objectToString(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}