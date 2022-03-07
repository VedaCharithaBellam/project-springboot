package com.Kodem.project.service;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class RegistrationService  {

    @Autowired
    private RegistrationRepository repository;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception{


        String email= user.getEmail();

        if(email!= null && "".equals(email)){

            User userobj= repository.findByEmail(email);
            if(userobj !=null){
                throw new Exception("user with "+ email+"already exists");
            }
        }
        User userObj=null;
        userObj=repository.save(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {

        String email = user.getEmail();
        String password=user.getPassword();
        User useObj=null;
        if( email != null && password !=null){

            useObj=repository.findByEmailAndPassword(email, password);

        }
        if(useObj ==null){
            throw new Exception("bad credentials");
        }
        return useObj;
    }

}
