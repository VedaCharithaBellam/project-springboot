package com.Kodem.project.service;

import com.Kodem.project.model.Certification;
import com.Kodem.project.repostitory.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

        @Autowired
        private CertificationRepository repo;

        public List<Certification> fetchCertificationList(){
            return repo.findAll();
        }

        public Certification saveCertificationToDB(Certification certification){
            return repo.save(certification);
        }

        public Optional<Certification> saveCertificationById(int certification_id){
            return repo.findById(certification_id);
         }

        public String deleteCertificationById(int certification_id){
            String result;
            try {
                repo.deleteById(certification_id);
                result="Certification successfully deleted";
            }
            catch (Exception e){
                result="Certification with id is not deleted";
            }
            return result;
    }
}
