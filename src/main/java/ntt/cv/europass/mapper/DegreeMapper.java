package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.DegreeDTO;
import ntt.cv.europass.entity.Degree;

public class DegreeMapper {

    public static Degree mapToEntity(DegreeDTO dto) {
        if (dto == null) {
            return null;
        }

        return Degree.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .institution(InstitutionMapper.mapToEntity(dto.getInstitution()))
                .sector(SectorMapper.mapToEntity(dto.getSector()))
                .build();
    }
}

