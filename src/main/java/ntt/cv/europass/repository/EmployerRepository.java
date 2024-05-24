package ntt.cv.europass.repository;

import ntt.cv.europass.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Employer findByName(String name);
}
