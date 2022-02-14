package com.Kodem.project.service;

import com.Kodem.project.model.Certification;
import com.Kodem.project.model.Skill;
import com.Kodem.project.repostitory.CertificationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

        @Autowired
        private CertificationRepository repo;

        @Autowired
        private RegistrationRepository r_repo;

        public List<Certification> fetchCertificationList(){
            return repo.findAll();
        }

        public Certification saveCertificationToDB(Certification certification, int user_id){

            certification.setUser(r_repo.findById(user_id));
            return repo.save(certification);
        }

        public Optional<Certification> saveCertificationById(int user_id){
            return repo.findById(user_id);
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
    public Optional<Certification> fetchCertificationByid(int certification_id) {
        return repo.findById(certification_id);
    }
}
