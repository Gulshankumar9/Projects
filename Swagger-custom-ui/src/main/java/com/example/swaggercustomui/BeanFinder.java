package com.example.swaggercustomui;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanFinder implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    @Autowired
    public BeanFinder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        findOpenApiBeans();
    }

    public void findOpenApiBeans() {
        // Get all bean names
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        // Loop through all beans
        for (String beanName : beanNames) {
            // Get the bean
            Object bean = applicationContext.getBean(beanName);

            // Check if the bean is an instance of OpenAPI
            if (bean instanceof OpenAPI) {
                System.out.println("Found an OpenAPI bean: " + beanName);
            }
        }
    }
}