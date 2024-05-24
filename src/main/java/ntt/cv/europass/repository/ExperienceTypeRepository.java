package ntt.cv.europass.repository;

import ntt.cv.europass.entity.ExperienceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceTypeRepository extends JpaRepository<ExperienceType, Long> {

    ExperienceType findByName(String name);
}
