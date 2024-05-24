package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.EducationDTO;
import ntt.cv.europass.dto.ResumeDTO;
import ntt.cv.europass.entity.Education;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EducationMapper {

    public static Education mapToEntity(EducationDTO dto) {
        if (dto == null) {
            return null;
        }

        List<ResumeDTO> resumes = dto.getResumes();
        if (resumes == null) {
            resumes = new ArrayList<>();
        }

        return Education.builder()
                .id(dto.getId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .degree(DegreeMapper.mapToEntity(dto.getDegree()))
                .resumes(resumes.stream()
                        .map(ResumeMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
