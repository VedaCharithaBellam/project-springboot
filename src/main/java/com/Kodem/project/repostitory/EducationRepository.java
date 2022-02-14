package com.Kodem.project.repostitory;

import com.Kodem.project.model.Education;
import com.Kodem.project.model.Experience;
import com.Kodem.project.model.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    public List<Education> findByUser(Optional<User> user);
}
