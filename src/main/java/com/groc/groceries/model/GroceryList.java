package com.groc.groceries.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lists")
public class GroceryList {

    @Id
    private String uuid;
    private String name;
    private String token;
    private Object items;

    public GroceryList(){

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getList() {
        return items;
    }

    public void setList(Object items) {
        this.items = items;
    }
}
