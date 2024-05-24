package ntt.cv.europass.service;


import ntt.cv.europass.entity.Project;
import ntt.cv.europass.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends MainService<Project, Long> {
    @Autowired
    public ProjectService(ProjectRepository repository) {
        super(repository);
    }
}
