package com.umitunal;

import com.umitunal.config.ApplicationConfig;
import com.umitunal.services.MongoDataService;
import com.umitunal.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: uunal
 * Date: 3/27/12
 * Time: 3:30 PM
 */
public class StandTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);
        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();


        MongoDataService mongoDataService = context.getBean(MongoDataService.class);

        mongoDataService.initDataService();
        //ProductService productService = context.getBean(ProductService.class);



    }
}
