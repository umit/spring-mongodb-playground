package com.umitunal.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 2:01 PM
 */
@Document(collection = "products")
public class Product {
    
    @Id
    private ObjectId id;

    private Date createdAt;

    private String title;
        
    private String description;

    private Double price;

    private List<ProductComment> productCommentList = new ArrayList<ProductComment>();
    
    private List<String> keywordList = new ArrayList<String>();

    public Product() {
    }

    public Product(ObjectId id, Date createdAt, String title, String description, Double price, List<ProductComment> productCommentList, List<String> keywordList) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
        this.price = price;
        this.productCommentList = productCommentList;
        this.keywordList = keywordList;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductComment> getProductCommentList() {
        return productCommentList;
    }

    public void setProductCommentList(List<ProductComment> productCommentList) {
        this.productCommentList = productCommentList;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }
}