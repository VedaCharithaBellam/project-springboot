package com.Kodem.project.service;
import com.Kodem.project.model.Education;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.EducationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
@RestController
public class EducationService {

    @Autowired
    private EducationRepository repository;

    @Autowired
    private RegistrationRepository registration_repository;

    @GetMapping("/geteducationListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Education> fetchEducationList(@PathVariable int user_id) {
        User user = registration_repository.findById(user_id);
        return repository.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addeducation/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Education saveEducation(@RequestBody Education education, @PathVariable int user_id) {
        education.setUser(registration_repository.findById(user_id));
        return repository.save(education);
    }

    @GetMapping("/geteducationById/{edu_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Education> fetchEducationById(@PathVariable int edu_id) {

        return repository.findById(edu_id);
    }
    @DeleteMapping("/deleteeducationById/{edu_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteEducationById(@PathVariable int edu_id) {
        String result;
        try {
            repository.deleteById(edu_id);
            result="Education successfully deleted";
        }
        catch (Exception e){
            result="Education with id is not deleted";
        }
        return result;
    }

}
