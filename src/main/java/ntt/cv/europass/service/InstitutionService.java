package ntt.cv.europass.service;

import ntt.cv.europass.entity.City;
import ntt.cv.europass.entity.Institution;
import ntt.cv.europass.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService extends MainService<Institution, Long> {

    private final InstitutionRepository institutionRepository;
    private final CityService cityService;

    @Autowired
    public InstitutionService(InstitutionRepository repository, InstitutionRepository institutionRepository, CityService cityService) {
        super(repository);
        this.institutionRepository = institutionRepository;
        this.cityService = cityService;
    }

    @Override
    public Institution save(Institution entity) {
        if(entity == null){
            return  null;
        }
        Institution institutionExist = institutionRepository.findByName(entity.getName());
        if(institutionExist != null){
            return institutionExist;
        }

            City city = cityService.save(entity.getCity());
            entity.setCity(city);

        return super.save(entity);
    }
}
