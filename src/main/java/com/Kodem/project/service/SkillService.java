package com.Kodem.project.service;
import com.Kodem.project.model.Skill;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.repostitory.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
public class SkillService {
    @Autowired
    private SkillRepository repository;
    @Autowired
    private RegistrationRepository registration_repo;

    @GetMapping("/getskillListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Skill> fetchSkillList(@PathVariable int user_id) {
        User user = registration_repo.findById(user_id);
        return repository.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addskill/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill saveSkill(@RequestBody Skill skill,@PathVariable int user_id)
    {
        skill.setUser(registration_repo.findById(user_id));
        return repository.save(skill);
    }

    @GetMapping("/getskillById/{skill_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Skill> fetchSkillById(@PathVariable int skill_id) {

        return repository.findById(skill_id);
    }
    @DeleteMapping("/deleteskillById/{skill_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteSkillById(@PathVariable int skill_id) {
        String result;
        try {
            repository.deleteById(skill_id);
            result="Skill successfully deleted";
        }
        catch (Exception e){
            result="Skill with id is not deleted";
        }
        return result;
    }



}
