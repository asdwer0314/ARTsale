package ru.sfedu.lab6Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import ru.sfedu.Constants;

import java.util.Arrays;


public class Mongo {

    public static void main(String[] args ){

        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder()
                    .register(
                            ClassModel.builder(AbsProducts.class)
                                    .enableDiscriminator(true)
                                    .build(),
                            ClassModel.builder(Product.class)
                                    .enableDiscriminator(true)
                                    .build())
                    .automatic(true)
                    .build())
        );


        MongoCollection <AbsProducts> collection = new MongoClient
                (new MongoClientURI(Constants.MONGO_URI))
                .getDatabase("Data")
                .withCodecRegistry(codecRegistry)
                .getCollection("Users", AbsProducts.class);


        AbsProducts pojo = collection.find(Filters.eq("_id",2)).first();
        if (pojo != null){
            System.out.println(pojo.getSphere());
        } else {
            collection.insertOne(new Product(1,"Rob", Product.Sphere.nana,Arrays.asList(
                    new Product(2,"Max", Product.Sphere.haha, null),
                    new Product(3,"Kate", Product.Sphere.lala, null),
                    new Product(4,"Ben", Product.Sphere.tada, null)
                    )));
        }











        /** ищем значение по ключу элемента и документа
        Document founded = collection.find(new Document("id",3)).first();
        if (founded != null){
            System.out.println(founded.getString("booo"));
        } else {
            Document document = new Document("id", 3);
            document.put("1", "nana");
            document.put("c", "lala");
            document.put("booo", "haha");
            document.put("x", "tada");
            document.put("5", Arrays.asList("haha","lala","nana","tada","gaga"));
            document.put("6", "tada");

            collection.insertOne(document);
        }

        //добавляем элемент (новое поле)
        collection.updateOne(Filters.eq("id",3), new Document(
                "$set",
                new Document("some filed", "some component")
        ));

        //обновляем элемент
        collection.updateOne(Filters.eq("id",3), new Document(
                "$set",
                new Document("6", "karkar")
        ));
        */
    }
}