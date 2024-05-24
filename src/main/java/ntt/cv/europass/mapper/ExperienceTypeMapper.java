package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.ExperienceTypeDTO;
import ntt.cv.europass.entity.ExperienceType;

import java.util.stream.Collectors;

public class ExperienceTypeMapper {

    public static ExperienceType mapToEntity(ExperienceTypeDTO dto) {
        if (dto == null) {
            return null;
        }

        return ExperienceType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .experiences(dto.getExperiences().stream()
                        .map(ExperienceMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
