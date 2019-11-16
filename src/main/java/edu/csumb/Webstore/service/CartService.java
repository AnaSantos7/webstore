package edu.csumb.Webstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.CartRepository;
import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.repositories.UserRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    ProductRepository productRepository;
    UserRepository userRepository;

    public Cart addProductToCart(String username, String prod_id, Integer quantity) {
        Cart cart = null;
        Optional<Cart> checkCart = cartRepository.findByUsername(username);
        if (checkCart.isPresent()) {
            cart = checkCart.get();
            cart.setProducts(prod_id, quantity);
        }
        else {
            cart = new Cart();
            cart.setUsername(username);
            cart.setProducts(prod_id, quantity);
        }
        cartRepository.save(cart);

        return cart;
    }

    public Cart updateCart(String username, String prod_id, Integer quantity) {
        Cart newCart = null;
        Optional<Cart> cartByUsername = cartRepository.findByUsername(username);

        if(cartByUsername.isPresent())
            newCart = cartByUsername.get();
        else
            return newCart;

        if(newCart.getProducts() != null){
            Integer temp = newCart.getProducts().get(prod_id);
            Integer value = quantity;
            if(value.intValue() == 0)
                newCart.getProducts().remove(prod_id);
            else
                newCart.getProducts().put(prod_id, value);
        }
        
        return newCart;
    }

    public Cart checkOut(String username) {
        Product currProduct = null;
        Cart newCart = null;
       
        Optional<Cart> userCart = cartRepository.findByUsername(username);

        if (userCart.isPresent()) {
            newCart = userCart.get();
        
            HashMap<String,Integer> products = newCart.getProducts();

            for (String key : products.keySet()) {
                Optional<Product> prod = productRepository.findById(key);
                if (prod.isPresent()){
                    currProduct = prod.get();
                    if (currProduct.getStock().intValue() > 0) {
                        Integer temp = (currProduct.getStock() - products.get(key));
                        currProduct.setStock(temp);
                        productRepository.save(currProduct);
                    }
                }

            }
        }
        if (newCart != null) {
            newCart.getProducts().clear();
            cartRepository.save(newCart);
        }
        return newCart;
    }

    public Iterable<Cart> getAll() {
        List<Cart> result = cartRepository.findAll();
        return result;
    }
}