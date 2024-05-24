package ntt.cv.europass.service;

import ntt.cv.europass.entity.City;
import ntt.cv.europass.entity.Country;
import ntt.cv.europass.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService extends MainService<Country, Long> {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository repository, CountryRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country entity) {
        if(entity == null){
            return  null;
        }
        Country existingCountry = countryRepository.findByName(entity.getName());
        if (existingCountry != null) {
            // City with the same name already exists, return the existing city

            return existingCountry;
        }

        return super.save(entity);
    }

    @Override
    public List<Country> saveMultiple(List<Country> entities) {
        List<Country> countries = new ArrayList<>();

        for (Country country: entities){
            countries.add(save(country));
        }

        return countries;
    }
}
