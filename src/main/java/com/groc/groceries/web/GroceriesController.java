package com.groc.groceries.web;

import com.groc.groceries.model.GroceryList;
import com.groc.groceries.model.Response;
import com.groc.groceries.service.GroceriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/groceries")
public class GroceriesController {

    private Logger logger = LoggerFactory.getLogger(GroceriesController.class);
    @Autowired
    private GroceriesService groceriesService;

    @RequestMapping(
            path = "/v1/get/lists",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<Iterable<GroceryList>> getGroceryListsForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        logger.info("Request for /v1/get/lists");
        return new ResponseEntity(groceriesService.getListById(request.getToken()), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/create/list",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<Response> createGroceryListsForUser(@RequestBody GroceryList request) {
        logger.info("/create/list call for UUID: " + request.getUuid());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.createListForUser(request), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/delete/list",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public ResponseEntity<Response> deleteGroceryListForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.deleteListForUser(request.getUuid()), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/update/list",
            method = RequestMethod.PATCH,
            produces = "application/json"
    )
    public ResponseEntity<Response> updateGroceryListForUser(@RequestBody GroceryList request) {
        logger.info("/update/list call for UUID: " + request.getUuid());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.updateListById(request), headers, HttpStatus.OK);
    }
}
