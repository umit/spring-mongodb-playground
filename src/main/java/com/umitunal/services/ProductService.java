package com.umitunal.services;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.umitunal.domain.Product;

public class ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public ProductService() {
    }

    public void insert(Product product) {
        this.mongoTemplate.insert(product);
    }

    public List<Product> getAllProducts(){
        return this.mongoTemplate.findAll(Product.class);
    }

    public List<Product> getAllProducts(int start, int max) {
        return  this.mongoTemplate.find(new Query().skip(start).limit(max),Product.class);
    }

    public Product findById(ObjectId objectId) {
        return this.mongoTemplate.findById(objectId, Product.class);
    }

    public List<Product> findByKeyword(String keyword){
        return mongoTemplate.find(new Query(Criteria.where("keyword").is(keyword)), Product.class);
    }

    public void saveOrUpdate(Product product) {
        this.mongoTemplate.save(product);
    }
}