package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.ExperienceDTO;
import ntt.cv.europass.entity.Experience;

public class ExperienceMapper {

    public static Experience mapToEntity(ExperienceDTO dto) {
        if (dto == null) {
            return null;
        }

        return Experience.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
                .city(CityMapper.mapToEntity(dto.getCity()))
                .resume(ResumeMapper.mapToEntity(dto.getResume()))
                .employer(EmployerMapper.mapToEntity(dto.getEmployer()))
                .experienceType(ExperienceTypeMapper.mapToEntity(dto.getExperienceType()))
                .client(ClientMapper.mapToEntity(dto.getClient()))
                .project(ProjectMapper.mapToEntity(dto.getProject()))
                .build();
    }
}
