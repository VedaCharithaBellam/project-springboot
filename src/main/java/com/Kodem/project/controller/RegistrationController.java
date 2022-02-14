package com.Kodem.project.controller;

import com.Kodem.project.model.User;
import com.Kodem.project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception{


        String tempEmail= user.getEmail();

                if(tempEmail!= null && "".equals(tempEmail)){

                    User userobj= service.fetchUserByEmail(tempEmail);
                    if(userobj !=null){
                        throw new Exception("user with "+ tempEmail+"already exists");
                    }
                }
        User userObj=null;
        userObj=service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        
        String tempEmail = user.getEmail();
        String tempPass=user.getPassword();
        User useObj=null;
        if( tempEmail != null && tempPass !=null){

            useObj=service.fetchUserByEmailAndPassword(tempEmail, tempPass);
            
        }
        if(useObj ==null){
            throw new Exception("bad credentials");
        }
        return useObj;
    }

}
