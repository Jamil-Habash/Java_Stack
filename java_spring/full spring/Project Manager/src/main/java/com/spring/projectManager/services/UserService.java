package com.spring.projectManager.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.spring.projectManager.models.*;
import com.spring.projectManager.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User register(User newUser, BindingResult result) {

        if (result.hasErrors()) {
            return null;
        }
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue(
                "confirmPassword",
                "Matches",
                "Passwords do not match!"
            );
            return null;
        }
        Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());

        if (optionalUser.isPresent()) {
            result.rejectValue(
                "email",
                "Unique",
                "An account with this email already exists!"
            );
            return null;
        }
        String hashedPassword = BCrypt.hashpw(
            newUser.getPassword(),
            BCrypt.gensalt()
        );

        newUser.setPassword(hashedPassword);
        return userRepo.save(newUser);
    }


    public User login(LoginUser newLogin, BindingResult result) {
        if (result.hasErrors()) {
            return null;
        }
        Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());

        if (optionalUser.isEmpty()) {
            result.rejectValue(
                "email",
                "Matches",
                "Invalid email or password!"
            );
            return null;
        }

        User user = optionalUser.get();

        if (!BCrypt.checkpw(
                newLogin.getPassword(),
                user.getPassword()
        )) {
            result.rejectValue(
                "password",
                "Matches",
                "Invalid email or password!"
            );
            return null;
        }

        return user;

    }

    public User findUserByEmail(String email){
        Optional<User> user = userRepo.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        } else{
            return null;
        }
    }

    public User findUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        } else{
            return null;
        }
    }

    public void updateUser(User user){
        userRepo.save(user);
    }
 
}

