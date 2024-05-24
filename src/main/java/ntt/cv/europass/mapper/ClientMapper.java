package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.ClientDTO;
import ntt.cv.europass.entity.Client;

import java.util.stream.Collectors;

public class ClientMapper {

    public static Client mapToEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }

        return Client.builder()
                .id(dto.getId())
                .name(dto.getName())
                .experiences(dto.getExperiences().stream()
                        .map(ExperienceMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
