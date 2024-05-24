package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.SectorDTO;
import ntt.cv.europass.entity.Sector;

public class SectorMapper {

    public static Sector mapToEntity(SectorDTO sectorDTO) {
        if (sectorDTO == null) {
            return null;
        }

        return Sector.builder()
                .id(sectorDTO.getId())
                .name(sectorDTO.getName())
                .description(sectorDTO.getDescription())
                .build();
    }
}
