package com.Kodem.project.service;
import com.Kodem.project.model.Education;
import com.Kodem.project.repostitory.EducationRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EducationService {

    @Autowired
    private EducationRepository repo;

    @Autowired
    private RegistrationRepository r_repo;

    public List<Education> fetchEducationList(){
        return repo.findAll();
    }

    public Education saveEducationToDB(Education education,int user_id){
        education.setUser(r_repo.findById(user_id));
        return repo.save(education);
    }

    public Optional<Education> saveEducationById(int edu_id){
        return repo.findById(edu_id);
    }

    public String deleteEducationById(int edu_id){
        String result;
        try {
            repo.deleteById(edu_id);
            result="Education successfully deleted";
        }
        catch (Exception e){
            result="Education with id is not deleted";
        }
        return result;
    }
    public Optional<Education> fetchEducationByid(int edu_id) {
        return repo.findById(edu_id);
    }
}
