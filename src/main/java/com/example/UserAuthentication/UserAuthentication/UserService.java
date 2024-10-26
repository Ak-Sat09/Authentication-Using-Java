package com.example.UserAuthentication.UserAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) { 
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User with this email already exists");
        }
        return userRepository.save(user);
    }

    public User loginUser(String email , String passsword){
        User user = userRepository.findByEmail(email);
        if(user == null || !user.getPassword().equals(passsword)) throw new RuntimeException("Invalid email or password");
        return user;
    }
}
