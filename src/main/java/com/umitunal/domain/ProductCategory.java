package com.umitunal.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 2:19 PM
 */
public class ProductCategory {

    @Id
    private ObjectId id;

    private String categoryName;

    public ProductCategory() {
    }

    public ProductCategory(ObjectId id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
