package ntt.cv.europass.service;

import ntt.cv.europass.entity.Employer;
import ntt.cv.europass.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService extends MainService<Employer, Long> {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository repository, EmployerRepository employerRepository) {
        super(repository);
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer save(Employer entity) {
        if(entity == null){
            return  null;
        }
        Employer employerExists = employerRepository.findByName(entity.getName());

        if(employerExists != null){
            return  employerExists;
        }
        return super.save(entity);
    }
}
