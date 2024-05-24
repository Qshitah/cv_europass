package ntt.cv.europass.service;


import ntt.cv.europass.entity.*;
import ntt.cv.europass.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService extends MainService<Experience, Long> {
    private final CityService cityService;
    private final EmployerService employerService;
    private final ExperienceTypeService experienceTypeService;
    private final ClientService clientService;
    private final ProjectService projectService;
    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository repository, CityService cityService, EmployerService employerService, ExperienceTypeService experienceTypeService, ClientService clientService, ProjectService projectService, ExperienceRepository experienceRepository) {
        super(repository);
        this.cityService = cityService;
        this.employerService = employerService;
        this.experienceTypeService = experienceTypeService;
        this.clientService = clientService;
        this.projectService = projectService;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> saveMultiple(List<Experience> entities) {
        List<Experience> savedExperiences = new ArrayList<>();
        for (Experience experience : entities) {

            City city = cityService.save(experience.getCity());
            experience.setCity(city);

            Employer employer = employerService.save(experience.getEmployer());
            experience.setEmployer(employer);

            ExperienceType experienceType = experienceTypeService.save(experience.getExperienceType());
            experience.setExperienceType(experienceType);

            Client client = clientService.save(experience.getClient());
            experience.setClient(client);

            Project project = projectService.save(experience.getProject());
            experience.setProject(project);

            Experience savedExperience = experienceRepository.save(experience);
            savedExperiences.add(savedExperience);
        }
        return savedExperiences;
    }
}
