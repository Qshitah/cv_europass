package ntt.cv.europass.repository;

import ntt.cv.europass.entity.LanguageProficiency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageProficiencyRepository extends JpaRepository<LanguageProficiency, Long> {
}
