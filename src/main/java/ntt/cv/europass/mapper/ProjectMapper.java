package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.ProjectDTO;
import ntt.cv.europass.entity.Project;

public class ProjectMapper {

    public static Project mapToEntity(ProjectDTO projectDTO) {
        if (projectDTO == null) {
            return null;
        }

        return Project.builder()
                .id(projectDTO.getId())
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .build();
    }
}
