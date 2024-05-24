package ntt.cv.europass.service;

import ntt.cv.europass.entity.Degree;
import ntt.cv.europass.entity.Education;
import ntt.cv.europass.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EducationService extends MainService<Education, Long> {

    private final DegreeService degreeService;

    @Autowired
    public EducationService(EducationRepository repository, DegreeService degreeService) {
        super(repository);
        this.degreeService = degreeService;
    }

    @Override
    public List<Education> saveMultiple(List<Education> entities) {
        List<Education> savedEducations = new ArrayList<>();

        for (Education education : entities) {
            Degree degree = degreeService.save(education.getDegree());
            education.setDegree(degree);
            savedEducations.add(super.save(education));
        }

        return savedEducations;
    }
}