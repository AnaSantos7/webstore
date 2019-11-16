package edu.csumb.Webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;

@Service
public class UserService {
    @Autowired 
    UserRepository userRepository;

    public Boolean authUser(String username, String password) {
       User user = userRepository.findByUsername(username);
        
        if (user == null) return false;
        if (!user.getPassword().equals(password))
            return false;
        return true;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Iterable<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }     
}