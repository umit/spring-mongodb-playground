package com.umitunal.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.umitunal.config.ApplicationConfig;
import com.umitunal.config.MongoConfiguration;
import com.umitunal.config.TestMongoConfiguration;
import com.umitunal.domain.Product;
import com.umitunal.util.MongoDBTestHelper;
import com.umitunal.util.TitleAndPrice;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/28/12
 * Time: 10:18 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
                     classes = {
                             ApplicationConfig.class,
                             MongoConfiguration.class,
                             TestMongoConfiguration.class
                     }
)
@ActiveProfiles("test")
public class ProductServiceIntegrationTest {

    public static final int PRODUCT_LIST_SIZE = 100;

    private @Autowired ProductService productService;

    private @Autowired MongoDBTestHelper mongoDBTestHelper;

    private @Autowired MongoDataService mongoDataService;
    
    private @Autowired MongoOperations mongoOperations;

    @Before
    public void init() {
       //mongoDBTestHelper.drop(Product.class);
       List<Product> products =  mongoDataService.prepareProductList(PRODUCT_LIST_SIZE);
       mongoDBTestHelper.init(products, Product.class);
    }
    
    @Test
    public void getAllProduct() {
       assertEquals(PRODUCT_LIST_SIZE, mongoDBTestHelper.getAll(Product.class).size());
    }

    @Test
    public void insertProduct() {
        Product product = mongoDataService.prepareProductList(1).get(0);
        assertNotNull(product);

        productService.insert(product);

        Product actualProduct = mongoDBTestHelper.findOneById(product.getId(), Product.class);
        assertEquals(product.getId(),actualProduct.getId());
    }

    @Test
    public void updateProductTitle() {
        Product product = mongoDataService.prepareProductList(1).get(0);
        assertNotNull(product);
        productService.insert(product);

        String productTitle = UUID.randomUUID().toString();

        Product testProduct = mongoDBTestHelper.findOneById(product.getId(), Product.class);
        assertNotNull(testProduct);
        testProduct.setTitle(productTitle);
        productService.saveOrUpdate(testProduct);

        Product actualProduct = mongoDBTestHelper.findOneById(product.getId(), Product.class);

        assertEquals(productTitle,actualProduct.getTitle());

    }
    
    @Test
    public void mapReduceTest() {
    	MapReduceResults<TitleAndPrice> mapReduceResults = mongoOperations.mapReduce("products", "classpath:map.js", "classpath:reduce.js", TitleAndPrice.class);
    	System.out.println(mapReduceResults.getRawResults().get("results"));
    }

}
