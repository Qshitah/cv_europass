package ntt.cv.europass.service;

import ntt.cv.europass.entity.Degree;
import ntt.cv.europass.entity.Institution;
import ntt.cv.europass.entity.Sector;
import ntt.cv.europass.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeService extends MainService<Degree, Long> {

    private final InstitutionService institutionService;
    private final SectorService sectorService;

    @Autowired
    public DegreeService(DegreeRepository repository, InstitutionService institutionService, SectorService sectorService) {
        super(repository);
        this.institutionService = institutionService;
        this.sectorService = sectorService;
    }

    @Override
    public Degree save(Degree entity) {
        if(entity == null){
            return  null;
        }
        Sector sector = sectorService.save(entity.getSector());
        entity.setSector(sector);

        Institution institution = institutionService.save(entity.getInstitution());
        entity.setInstitution(institution);

        return super.save(entity);
    }
}
