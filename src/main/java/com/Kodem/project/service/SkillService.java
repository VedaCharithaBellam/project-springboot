package com.Kodem.project.service;
import com.Kodem.project.model.Skill;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.repostitory.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    private SkillRepository repo;
    @Autowired
    private RegistrationRepository r_repo;

    public List<Skill> fetchSkillList(){
        return repo.findAll();
    }

    public Skill saveSkillToDB(Skill skill,int user_id){
        skill.setUser(r_repo.findById(user_id));
        return repo.save(skill);
    }

    public Optional<Skill> saveSkillById(int skill_id){
        return repo.findById(skill_id);
    }

    public String deleteSkillById(int skill_id){
        String result;
        try {
            repo.deleteById(skill_id);
            result="Skill successfully deleted";
        }
        catch (Exception e){
            result="Skill with id is not deleted";
        }
        return result;
    }

    public Optional<Skill> fetchSkillByid(int skill_id) {
        return repo.findById(skill_id);
    }
}
