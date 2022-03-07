package com.Kodem.project.service;
import com.Kodem.project.model.Profile;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.ProfileRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
public class ProfileService {
    @Autowired
    private ProfileRepository repository;
    @Autowired
    private RegistrationRepository registration_repository;

    @GetMapping("/getprofileListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Profile> fetchProfileList(@PathVariable int user_id) {
        User user = registration_repository.findById(user_id);
        return repository.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addprofile/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Profile saveProfile(@RequestBody Profile profile, @PathVariable int user_id)
    {

        profile.setUser(registration_repository.findById(user_id));
        return repository.save(profile);
    }

    @GetMapping("/getprofileById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Profile> fetchProfileById(@PathVariable int id) {

        return repository.findById(id);
    }

    public List<Profile> fetchProfileList(){
        return repository.findAll();
    }
}
