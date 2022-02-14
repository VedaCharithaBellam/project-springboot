package com.Kodem.project.controller;
import com.Kodem.project.model.Experience;
import com.Kodem.project.model.Skill;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.ExperienceRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private ExperienceRepository exp_repo;



    @PostMapping("/addexperience/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Experience saveExperience(@RequestBody Experience experience, @PathVariable int user_id) {
        return service.saveExperienceToDB(experience,user_id);
    }

    @GetMapping("/getexperienceListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Experience> fetchExperienceList(@PathVariable int user_id) {
        User user = repo.findById(user_id);
        return exp_repo.findByUser(Optional.ofNullable(user));
    }

    @GetMapping("/getexperienceById/{exp_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Experience fetchExperienceById(@PathVariable int exp_id) {

        return service.fetchExperienceByid(exp_id).get();
    }
    @DeleteMapping("/deleteexperienceById/{exp_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteExperienceById(@PathVariable int exp_id) {
        return service.deleteExperienceById(exp_id);
    }


}
