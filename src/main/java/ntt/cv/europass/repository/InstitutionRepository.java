package ntt.cv.europass.repository;

import ntt.cv.europass.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findByName(String name);
}
