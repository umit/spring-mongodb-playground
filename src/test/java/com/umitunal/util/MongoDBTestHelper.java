package com.umitunal.util;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class MongoDBTestHelper {

    @Autowired
    private MongoTemplate mongoTemplate;

    public <T> void insert(Class<T> entityClass){
        mongoTemplate.insert(entityClass);
    }

    public <T> void update(Class<T> entityClass) {
        mongoTemplate.save(entityClass);
    }

    public <T> void init(List<T> documents, Class<T> entityClass) {
        mongoTemplate.insert(documents,entityClass);
    }


    public <T> List<T> getAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    public <T> void drop(Class<T> entityClass) {
        this.mongoTemplate.dropCollection(entityClass);
    }

    public <T> T findOneWhere(String where, String is, Class<T> entityClass) {
        return mongoTemplate.findOne(new Query(where(where).is(is)), entityClass);
    }

    public <T> T findOneById(ObjectId id, Class<T> entityClass) {
        return mongoTemplate.findById(id, entityClass);
    }

}
