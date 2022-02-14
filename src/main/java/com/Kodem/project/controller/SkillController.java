package com.Kodem.project.controller;
import com.Kodem.project.model.Skill;
import com.Kodem.project.model.User;
import com.Kodem.project.repostitory.RegistrationRepository;
import com.Kodem.project.repostitory.SkillRepository;
import com.Kodem.project.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class SkillController {
    @Autowired
    private SkillService service;

    @Autowired
    private RegistrationRepository repo;

    @Autowired
    private SkillRepository skill_repo;

    @GetMapping("/getskillListById/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Skill> fetchSkillList(@PathVariable int user_id) {
        User user = repo.findById(user_id);
        return skill_repo.findByUser(Optional.ofNullable(user));
    }

    @PostMapping("/addskill/{user_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill saveSkill(@RequestBody Skill skill,@PathVariable int user_id)
    {

        return service.saveSkillToDB(skill,user_id);
    }

    @GetMapping("/getskillById/{skill_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Skill fetchSkillById(@PathVariable int skill_id) {

        return service.fetchSkillByid(skill_id).get();
    }
    @DeleteMapping("/deleteskillById/{skill_id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteSkillById(@PathVariable int skill_id) {
        return service.deleteSkillById(skill_id);
    }
}
