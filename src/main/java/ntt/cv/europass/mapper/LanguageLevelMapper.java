package ntt.cv.europass.mapper;


import ntt.cv.europass.dto.LanguageLevelDTO;
import ntt.cv.europass.entity.LanguageProficiency.LanguageLevel;

public class LanguageLevelMapper {

    public static LanguageLevel mapToEntity(LanguageLevelDTO dto) {
        if (dto == null || dto.getLevel() == null) {
            return null;
        }

        return switch (dto.getLevel().toUpperCase()) {
            case "A1" -> LanguageLevel.A1;
            case "A2" -> LanguageLevel.A2;
            case "B1" -> LanguageLevel.B1;
            case "B2" -> LanguageLevel.B2;
            case "C1" -> LanguageLevel.C1;
            case "C2" -> LanguageLevel.C2;
            default -> throw new IllegalArgumentException("Invalid language level: " + dto.getLevel());
        };
    }
}
