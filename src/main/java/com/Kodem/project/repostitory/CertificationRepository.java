package com.Kodem.project.repostitory;
import com.Kodem.project.model.Certification;
import com.Kodem.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface CertificationRepository extends JpaRepository<Certification, Integer> {

    public List<Certification> findByUser(Optional<User> user);

}
