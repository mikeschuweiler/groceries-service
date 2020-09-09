package com.groc.groceries.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String connectionUri;

    /*
     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
     */
    public @Bean MongoClient mongoClient() {
        return MongoClients.create(connectionUri);
    }
}