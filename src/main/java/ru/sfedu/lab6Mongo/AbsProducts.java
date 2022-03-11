package ru.sfedu.lab6Mongo;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator
public interface AbsProducts {

    Product.Sphere getSphere();
    String getName();
    int getId();
    AbsProducts Mirror();

}
