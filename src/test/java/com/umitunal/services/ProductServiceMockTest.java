package com.umitunal.services;

import com.umitunal.domain.Product;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 5:19 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceMockTest {

    private @Mock MongoTemplate mongoTemplate;

    private @InjectMocks ProductService productService;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insertNewProduct(){
        final Product product = new Product();
        productService.insert(product);
        verify(mongoTemplate).insert(eq(product));
    }

    @Test
    public void saveProduct(){
        final Product product = new Product();
        productService.saveOrUpdate(product);
        verify(mongoTemplate).save(eq(product));
    }

    @Test
    public void getAllProducts(){
        when(productService.getAllProducts()).thenReturn(new ArrayList<Product>());
        List<Product> productList = productService.getAllProducts();
        assertNotNull(productList);
        verify(mongoTemplate).findAll(Product.class);
    }

    @Test
    public void findByProductId() {
        when(mongoTemplate.findById(isA(ObjectId.class),eq(Product.class))).thenReturn(new Product());

        final ObjectId objectId = new ObjectId();
        Product product = productService.findById(objectId);

        verify(mongoTemplate).findById(eq(objectId),eq(Product.class));
        assertNotNull(product);
    }

}
