package com.groc.groceries.web;

import com.groc.groceries.model.GroceryList;
import com.groc.groceries.service.GroceriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/groceries")
public class GroceryController {

    @Autowired
    private GroceriesService groceriesService;

    @RequestMapping(
            path = "/v1/get/lists",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<Iterable<GroceryList>> getGroceryListsForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.getListById(request.getToken()), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/create/list",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<String> createGroceryListsForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.createListForUser(request), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/delete/list",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public ResponseEntity<String> deleteGroceryListForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.deleteListForUser(request.getUuid()), headers, HttpStatus.OK);
    }

    @RequestMapping(
            path = "/v1/update/list",
            method = RequestMethod.PATCH,
            produces = "application/json"
    )
    public ResponseEntity<String> updateGroceryListForUser(@RequestBody GroceryList request) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(groceriesService.updateListById(request), headers, HttpStatus.OK);
    }
}
