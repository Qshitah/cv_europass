package ntt.cv.europass.repository;

import ntt.cv.europass.entity.City;
import ntt.cv.europass.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);

}

