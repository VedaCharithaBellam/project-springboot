package com.Kodem.project.controller;
import com.Kodem.project.model.Profile;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.ProfileRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProfileRestController {
    @Autowired
    private ProfileService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private ProfileRepository p_repo;

    @GetMapping("/getprofileListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Profile> fetchProfileList(@PathVariable int user_id) {
        User user = repo.findById(user_id);
        return p_repo.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addprofile/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Profile saveProfile(@RequestBody Profile profile,@PathVariable int user_id)
    {

        return service.saveProfileToDB(profile,user_id);
    }

    @GetMapping("/getprofileById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Profile fetchProfileById(@PathVariable int id) {

        return service.fetchProfileByid(id).get();
    }
    @DeleteMapping("/deleteprofileById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProfileById(@PathVariable int id) {
        return service.deleteProfileById(id);
    }
}
