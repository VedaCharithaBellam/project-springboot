package com.Kodem.project.service;

import com.Kodem.project.model.Certification;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.CertificationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
public class CertificationService {

        @Autowired
        private CertificationRepository repository;

        @Autowired
        private RegistrationRepository registration_repo;

    @GetMapping("/getcertificationListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Certification> fetchCertificationList(@PathVariable int user_id) {
        User user = registration_repo.findById(user_id);
        return repository.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addcertification/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Certification saveCertification(@RequestBody Certification certification, @PathVariable int user_id) {
        certification.setUser(registration_repo.findById(user_id));
        return repository.save(certification);
    }

    @GetMapping("/getcertificationById/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Certification> fetchCertificationById(@PathVariable int certification_id) {

        return repository.findById(certification_id);
    }
    @DeleteMapping("/deletecertificationById/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteCertificationById(@PathVariable int certification_id) {
        String result;
        try {
            repository.deleteById(certification_id);
            result="Certification successfully deleted";
        }
        catch (Exception e){
            result="Certification with id is not deleted";
        }
        return result;
    }


}
