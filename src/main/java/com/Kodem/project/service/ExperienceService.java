package com.Kodem.project.service;
import com.Kodem.project.model.Experience;
import com.Kodem.project.repostitory.ExperienceRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repo;

    @Autowired
    private RegistrationRepository r_repo;

    public List<Experience> fetchExperienceList(){
        return repo.findAll();
    }

    public Experience saveExperienceToDB(Experience experience, int user_id){
        experience.setUser(r_repo.findById(user_id));
        return repo.save(experience);
    }

    public Optional<Experience> saveExperienceById(int exp_id){
        return repo.findById(exp_id);
    }

    public String deleteExperienceById(int exp_id){
        String result;
        try {
            repo.deleteById(exp_id);
            result="Experience successfully deleted";
        }
        catch (Exception e){
            result="Experience with id is not deleted";
        }
        return result;
    }
    public Optional<Experience> fetchExperienceByid(int exp_id) {
        return repo.findById(exp_id);
    }
}
