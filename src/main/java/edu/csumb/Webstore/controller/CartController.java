package edu.csumb.Webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.service.CartService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.POST, value = "/cart/add/{username}/{prod_id}/{quantity}")
    @ApiOperation(value = "Adding a product to a cart.")
    public Cart addProductToCart(@RequestParam String username, @RequestParam String prod_id, @RequestParam Integer quantity) {
        return cartService.addProductToCart(username, prod_id, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart/{username}/{prod_id}/{quantity}")
    @ApiOperation(value = "Updates the cart's quantity of a product or removes product from cart.")
    public Cart updateCart(@RequestParam String username, @RequestParam String prod_id, @RequestParam Integer quantity) {
        return cartService.updateCart(username, prod_id, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart/checkout/{username}")
    @ApiOperation(value = "Clears user's cart, and removes the products from stock.")
    public Cart checkOut(@RequestParam String username) {
        return cartService.checkOut(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cart/getAll")
    @ApiOperation(value = "Get all the carts in the database")
    public Iterable<Cart> getAll() {
        return cartService.getAll();
    }
}