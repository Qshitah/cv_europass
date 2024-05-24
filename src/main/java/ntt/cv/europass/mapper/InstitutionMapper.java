package ntt.cv.europass.mapper;


import ntt.cv.europass.dto.InstitutionDTO;
import ntt.cv.europass.entity.Institution;

public class InstitutionMapper {

    public static Institution mapToEntity(InstitutionDTO dto) {
        if (dto == null) {
            return null;
        }

        return Institution.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(CityMapper.mapToEntity(dto.getCity()))
                .build();
    }
}
