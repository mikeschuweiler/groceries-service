package com.groc.groceries.service;

import com.groc.groceries.model.GroceryList;
import com.groc.groceries.model.Response;
import com.groc.groceries.repository.GroceryListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceriesService {

    private static final Logger logger = LoggerFactory.getLogger(GroceriesService.class);

    @Autowired
    private GroceryListRepository repository;

    public Iterable<GroceryList> getListById(String token) {
        logger.info("Called getListById with token: [{}]", token);
        return repository.findListsByToken(token);
    }

    public Response createListForUser(GroceryList list) {
        repository.save(list);
        return new Response("Added a new list");
    }

    public Response deleteListForUser(String uuid) {
        repository.deleteById(uuid);
        return new Response("Deleted list!");
    }

    public Iterable<GroceryList> updateListById(GroceryList list) {
        repository.save(list);
        return repository.findListsByUuid(list.getUuid());
    }

}
