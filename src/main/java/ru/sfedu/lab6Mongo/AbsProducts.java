package ru.sfedu.lab6Mongo;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator
public interface AbsPojo {

    Pojo.Role getRole();
    String getName();
    int getId();
    AbsPojo Mirror();

}
