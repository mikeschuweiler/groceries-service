package com.groc.groceries.repository;

import com.groc.groceries.model.GroceryList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface GroceryListRepository extends MongoRepository<GroceryList, String> {

    Iterable<GroceryList> findListsByUuid(String uuid);
    Iterable<GroceryList> findListsByToken(String token);

}
