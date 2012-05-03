package com.umitunal.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@Profile("test")
@ImportResource("classpath:properties-config.xml")
public class TestMongoConfiguration {

    private @Value("${mongo.databaseName}") String databaseName;
    private @Value("${mongo.hostName}") String hostName;
    private @Value("${mongo.portNumber}") int portNumber;

    public @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new Mongo(hostName, portNumber), databaseName);
    }
    
 
    public @Bean MongoTemplate mongoTemplate() throws Exception{
    	return new MongoTemplate(mongoDbFactory(),mappingMongoConverter());
    }
    
    public @Bean MappingMongoConverter mappingMongoConverter() throws Exception{
    	MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
    	mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return mappingMongoConverter;
    }
    
    

}