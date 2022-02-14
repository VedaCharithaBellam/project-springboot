package com.Kodem.project.controller;

import com.Kodem.project.model.Certification;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.CertificationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CertificationRestController {

    @Autowired
    private CertificationService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private CertificationRepository c_repo;

    @GetMapping("/getcertificationListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Certification> fetchCertificationList(@PathVariable int user_id) {
        User user = repo.findById(user_id);
        return c_repo.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addcertification/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Certification saveCertification(@RequestBody Certification certification, @PathVariable int user_id) {
        //  service.saveCertificationById(user_id);
        return service.saveCertificationToDB(certification,user_id);
    }

    @GetMapping("/getcertificationById/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Certification fetchCertificationById(@PathVariable int certification_id) {

        return service.fetchCertificationByid(certification_id).get();
    }
    @DeleteMapping("/deletecertificationById/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteCertificationById(@PathVariable int certification_id) {
        return service.deleteCertificationById(certification_id);
    }

}
