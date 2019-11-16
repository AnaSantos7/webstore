package edu.csumb.Webstore.model;

import java.util.HashMap;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class Cart {
    @Id
    @ApiModelProperty(required = false, hidden = true)
    String id;
    String username;
    HashMap<String, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, Integer> getProducts(){
        return products;
    }
    
    public void setProducts(String item, Integer quantity){
        this.products.put(item, quantity);
    }
}