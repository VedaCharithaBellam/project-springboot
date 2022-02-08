package com.Kodem.project.controller;

import com.Kodem.project.model.Certification;
import com.Kodem.project.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CertificationRestController {

    @Autowired
    private CertificationService service;


    @GetMapping("/getcertificationList")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Certification> fetchCertificationList() {

        List<Certification> certifications= new ArrayList<Certification>();

        certifications=service.fetchCertificationList();
        return certifications;
    }

    @PostMapping("/addcertification")
    @CrossOrigin(origins = "http://localhost:4200")
    public Certification saveCertification(@RequestBody Certification certification) {
        return service.saveCertificationToDB(certification);
    }

    @GetMapping("/getcertificationbyid/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Certification fetchCertificationById(@PathVariable int certification_id) {
        return service.saveCertificationById(certification_id).get();
    }
    @DeleteMapping("/deletecertificationbyid/{certification_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteCertificationById(@PathVariable int certification_id) {
        return service.deleteCertificationById(certification_id);
    }
}
