package com.umitunal.config;

import com.mongodb.WriteConcern;
import com.umitunal.services.MongoDataService;
import com.umitunal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 2:53 PM
 */
@Configuration
@ComponentScan(basePackages = "com.umitunal")
public class ApplicationConfig {

    @Autowired
    private MongoDbFactory mongoDbFactory;

    public @Bean MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);
        return  mongoTemplate;
    }

    public @Bean ProductService productService(){
        return new ProductService();
    }

    public @Bean MongoDataService mongoDataService() {
        return new MongoDataService();
    }


}
