package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class User {
    @Id
    @ApiModelProperty(required = false, hidden = true)
    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }
}