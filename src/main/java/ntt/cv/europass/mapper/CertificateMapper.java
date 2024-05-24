package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.CertificateDTO;
import ntt.cv.europass.entity.Certificate;

public class CertificateMapper {

    public static Certificate mapToEntity(CertificateDTO dto) {
        if (dto == null) {
            return null;
        }

        return Certificate.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
