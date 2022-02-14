package com.Kodem.project.repostitory;

import com.Kodem.project.model.Profile;
import com.Kodem.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public List<Profile> findByUser(Optional<User> user);
}
