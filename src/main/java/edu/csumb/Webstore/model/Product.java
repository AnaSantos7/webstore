//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class Product {
    private String name;
    @Id
    @ApiModelProperty(required = false, hidden = true)
    private String id;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    public String getName() {
        return name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}