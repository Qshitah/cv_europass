package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.CountryDTO;
import ntt.cv.europass.entity.Country;

import java.util.stream.Collectors;

public class CountryMapper {

    public static Country mapToEntity(CountryDTO dto) {
        if (dto == null) {
            return null;
        }

        return Country.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cities(dto.getCities().stream()
                        .map(CityMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .resumes(dto.getResumes().stream()
                        .map(ResumeMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
