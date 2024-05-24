package ntt.cv.europass.service;

import ntt.cv.europass.entity.Sector;
import ntt.cv.europass.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorService extends MainService<Sector, Long> {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository repository, SectorRepository sectorRepository) {
        super(repository);
        this.sectorRepository = sectorRepository;
    }

    @Override
    public Sector save(Sector entity) {
        if(entity == null){
            return  null;
        }
        Sector sectorExist = sectorRepository.findByName(entity.getName());
        if(sectorExist != null){
            return sectorExist;
        }
        return super.save(entity);
    }
}
