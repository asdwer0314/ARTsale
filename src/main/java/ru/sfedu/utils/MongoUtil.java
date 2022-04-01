package ru.sfedu.utils;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import ru.sfedu.api.IDataProvider;
import ru.sfedu.model.MongoModel;

import static ru.sfedu.Constants.*;


public class MongoUtil {
    private static final Logger log = LogManager.getLogger(ConfigurationUtil.class.getName());

    public MongoUtil(String s, String nana, Object o) {}

    public static void main(String[] args ){


        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder()
                    .register(
                            ClassModel.builder(IDataProvider.class)
                                    .enableDiscriminator(true)
                                    .build(),
                            ClassModel.builder(MongoModel.class)
                                    .enableDiscriminator(true)
                                    .build())
                    .automatic(true)
                    .build())
        );


        MongoCollection <IDataProvider> collection = new MongoClient
                (new MongoClientURI(MONGO_CNN))
                .getDatabase(MONGO_DB)
                .withCodecRegistry(codecRegistry)
                .getCollection(MONGO_CLL, IDataProvider.class);


        Document founded = (Document) collection.find(new Document("_id",3)).first();
        if (founded != null){
            log.debug("document not null");
        } else {
            collection.updateOne(Filters.eq("_id",3), new Document(
                    "$set",
                    new Document("some filed", "some component")));
        }


        collection.deleteOne(Filters.eq("Users1",5));


        /*

        //IDataProvider product = collection.find(Filters.eq("_id",5)).first();
        //IDataProvider product = null;

        if (product == null){
            collection.insertOne(new MongoModel(5,"Users1", MongoModel.Sphere.nana,Arrays.asList(
                    new MongoModel(2,"Sasha", MongoModel.Sphere.haha, null),
                    new MongoModel(3,"Kevin", MongoModel.Sphere.lala, null))));

        } else {
            collection.insertOne(new MongoModel(5,"Users2", MongoModel.Sphere.nana,Arrays.asList(
                    new MongoModel(2,"Max", MongoModel.Sphere.haha, null),
                    new MongoModel(3,"Kate", MongoModel.Sphere.lala, null),
                    new MongoModel(4,"Ben", MongoModel.Sphere.tada, null)
            )));

            //добавляем элемент (новое поле)
        collection.updateOne(Filters.eq("_id",3), new Document(
                "$set",
                new Document("some filed", "some component")
        ));

        //обновляем элемент
        collection.updateOne(Filters.eq("_id",3), new Document(
                "$set",
                new Document("6", "karkar")
        ));


            //ищем значение по ключу элемента и документа
        Document founded = (Document) collection.find(new Document("_id",3)).first();
        if (founded != null){
            System.out.println(founded.getString("booo"));
        } else {
            Document document = new Document("_id", 3);
            document.put("1", "nana");
            document.put("c", "lala");
            document.put("booo", "haha");
            document.put("x", "tada");
            document.put("5", Arrays.asList("haha","lala","nana","tada","gaga"));
            document.put("6", "tada");

            collection.insertOne((AbsProducts) document);
        }


        */
    }



//
//    void recordToMongo(String className, String methodName, Object object){
//        try {
//            long _id = new Date().getTime();
//            Date createdDate = new Date();
//            HistoryContent historyContent = new HistoryContent(className, createdDate,
//                    "System", methodName, object, "Success");
//            MongoClient client = new MongoClient(new MongoClientURI(getConfigurationEntry(MONGO_CNN)));
//            MongoDatabase database = client.getDatabase(getConfigurationEntry(MONGO_DB));
//            MongoCollection<Document> collection = database.getCollection(getConfigurationEntry(MONGO_CLL));
//            Document document = new Document();
//            document.put("id", MongoModel.get_idProducts());
//            document.put("className", MongoModel.getNameProducts());
//            document.put("createdDate", MongoModel.getDescriptionProducts());
//            collection.insertOne(document);
//        } catch (Exception e) {
//            log.error(e);
//        }
//    }
//



}