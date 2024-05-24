package ntt.cv.europass.service;

import ntt.cv.europass.entity.ExperienceType;
import ntt.cv.europass.repository.ExperienceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceTypeService extends MainService<ExperienceType, Long> {

    private final ExperienceTypeRepository experienceTypeRepository;

    @Autowired
    public ExperienceTypeService(ExperienceTypeRepository repository, ExperienceTypeRepository experienceTypeRepository) {
        super(repository);
        this.experienceTypeRepository = experienceTypeRepository;
    }

    @Override
    public ExperienceType save(ExperienceType entity) {
        if(entity == null){
            return  null;
        }
        ExperienceType experienceTypeExist = experienceTypeRepository.findByName(entity.getName());
        if(experienceTypeExist != null){
            return experienceTypeExist;
        }
        return super.save(entity);
    }
}
