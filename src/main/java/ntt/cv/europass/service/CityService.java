package ntt.cv.europass.service;

import ntt.cv.europass.entity.City;
import ntt.cv.europass.entity.Country;
import ntt.cv.europass.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends MainService<City, Long> {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    @Autowired
    public CityService(CityRepository repository, CityRepository cityRepository, CountryService countryService) {
        super(repository);
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    @Override
    public City save(City entity) {
        if(entity == null){
            return  null;
        }
        City existingCity = cityRepository.findByName(entity.getName());
        Country country = countryService.save(entity.getCountry());
        if (existingCity != null) {
            // City with the same name already exists, return the existing city
            return existingCity;
        } else {
            // City doesn't exist, proceed with saving
            entity.setCountry(country);
            return super.save(entity);
        }
    }
}