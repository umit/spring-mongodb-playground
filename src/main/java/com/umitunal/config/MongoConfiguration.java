package com.umitunal.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 2:57 PM
 */
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
