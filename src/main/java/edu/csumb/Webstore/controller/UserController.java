package edu.csumb.Webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}/{password}")
    @ApiOperation(value = "Given username and password, user will be authenticated.")
    public Boolean authUser(@RequestParam String username, @RequestParam String password) {
        return userService.authUser(username, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    @ApiOperation(value = "Get all the users in the database")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    } 

    @RequestMapping(method = RequestMethod.GET, value = "/user/getAll")
    @ApiOperation(value = "Get all the users in the database")
    public Iterable<User> getAll() {
        return userService.getAll();
    }
}