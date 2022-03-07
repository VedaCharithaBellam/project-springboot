package com.Kodem.project.service;
import com.Kodem.project.model.Experience;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.ExperienceRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    @Autowired
    private RegistrationRepository registration_repository;

    @PostMapping("/addexperience/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Experience saveExperience(@RequestBody Experience experience, @PathVariable int user_id) {
        experience.setUser(registration_repository.findById(user_id));
        return repository.save(experience);
    }

    @GetMapping("/getexperienceListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Experience> fetchExperienceList(@PathVariable int user_id) {
        User user = registration_repository.findById(user_id);
        return repository.findByUser(Optional.ofNullable(user));
    }

    @GetMapping("/getexperienceById/{exp_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Experience> fetchExperienceById(@PathVariable int exp_id) {

        return repository.findById(exp_id);
    }
    @DeleteMapping("/deleteexperienceById/{exp_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteExperienceById(@PathVariable int exp_id) {
        String result;
        try {
            repository.deleteById(exp_id);
            result="Experience successfully deleted";
        }
        catch (Exception e){
            result="Experience with id is not deleted";
        }
        return result;
    }

}
