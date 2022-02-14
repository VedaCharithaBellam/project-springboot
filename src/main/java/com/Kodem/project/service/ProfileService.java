package com.Kodem.project.service;
import com.Kodem.project.model.Profile;
import com.Kodem.project.repostitory.ProfileRepository;
import com.Kodem.project.repostitory.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repo;
    @Autowired
    private RegistrationRepository r_repo;

    public List<Profile> fetchProfileList(){
        return repo.findAll();
    }

    public Profile saveProfileToDB(Profile profile,int user_id){
        profile.setUser(r_repo.findById(user_id));
        return repo.save(profile);
    }

    public Optional<Profile> saveProfileById(int id){
        return repo.findById(id);
    }

    public String deleteProfileById(int id){
        String result;
        try {
            repo.deleteById(id);
            result="Profile successfully deleted";
        }
        catch (Exception e){
            result="Profile with id is not deleted";
        }
        return result;
    }

    public Optional<Profile> fetchProfileByid(int id) {
        return repo.findById(id);
    }
}
