package com.umitunal.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
@Profile("prod")
@ImportResource("classpath:properties-config.xml")
public class MongoConfiguration {

    private @Value("${mongo.databaseName}") String databaseName;
    private @Value("${mongo.hostName}")     String hostName;
    private @Value("${mongo.portNumber}")   int portNumber;

    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new Mongo(hostName, portNumber), databaseName);
    }

}
