package com.Kodem.project.controller;
import com.Kodem.project.model.Education;
import com.Kodem.project.model.Skill;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.EducationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EducationController {
    @Autowired
    private EducationService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private EducationRepository edu_repo;

    @GetMapping("/geteducationListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Education> fetchEducationList(@PathVariable int user_id) {
        User user = repo.findById(user_id);
        return edu_repo.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addeducation/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Education saveEducation(@RequestBody Education education, @PathVariable int user_id) {
        return service.saveEducationToDB(education,user_id);
    }

    @GetMapping("/geteducationById/{edu_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Education fetchEducationById(@PathVariable int edu_id) {

        return service.fetchEducationByid(edu_id).get();
    }
    @DeleteMapping("/deleteeducationById/{edu_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteEducationById(@PathVariable int edu_id) {
        return service.deleteEducationById(edu_id);
    }
}
