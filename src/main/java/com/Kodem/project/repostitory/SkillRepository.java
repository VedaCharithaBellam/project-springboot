package com.Kodem.project.repostitory;
import com.Kodem.project.model.Skill;
import com.Kodem.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    public List<Skill> findByUser(Optional<User> user);
}
