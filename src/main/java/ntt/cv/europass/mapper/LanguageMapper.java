package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.LanguageDTO;
import ntt.cv.europass.entity.Language;

public class LanguageMapper {

    public static Language mapToEntity(LanguageDTO dto) {
        if (dto == null) {
            return null;
        }

        return Language.builder()
                .id(dto.getId())
                .languageCode(dto.getLanguageCode())
                .build();
    }
}
