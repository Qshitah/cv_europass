package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.EmployerDTO;
import ntt.cv.europass.entity.Employer;

import java.util.stream.Collectors;

public class EmployerMapper {

    public static Employer mapToEntity(EmployerDTO dto) {
        if (dto == null) {
            return null;
        }

        return Employer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .experiences(dto.getExperiences().stream()
                        .map(ExperienceMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
