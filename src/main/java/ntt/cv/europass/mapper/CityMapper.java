package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.CityDTO;
import ntt.cv.europass.entity.City;

import java.util.stream.Collectors;

public class CityMapper {

    public static City mapToEntity(CityDTO dto) {
        if (dto == null) {
            return null;
        }

        return City.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(CountryMapper.mapToEntity(dto.getCountry()))
                .addresses(dto.getAddresses().stream()
                        .map(AddressMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .experiences(dto.getExperiences().stream()
                        .map(ExperienceMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .institutions(dto.getInstitutions().stream()
                        .map(InstitutionMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}

