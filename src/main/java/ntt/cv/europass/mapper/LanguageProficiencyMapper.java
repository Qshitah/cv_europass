package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.LanguageProficiencyDTO;
import ntt.cv.europass.entity.LanguageProficiency;

public class LanguageProficiencyMapper {

    public static LanguageProficiency mapToEntity(LanguageProficiencyDTO dto) {
        if (dto == null) {
            return null;
        }

        return LanguageProficiency.builder()
                .id(dto.getId())
                .resume(ResumeMapper.mapToEntity(dto.getResume()))
                .language(LanguageMapper.mapToEntity(dto.getLanguage()))
                .understandingListening(LanguageLevelMapper.mapToEntity(dto.getUnderstandingListening()))
                .understandingReading(LanguageLevelMapper.mapToEntity(dto.getUnderstandingReading()))
                .speakingInteraction(LanguageLevelMapper.mapToEntity(dto.getSpeakingInteraction()))
                .speakingProduction(LanguageLevelMapper.mapToEntity(dto.getSpeakingProduction()))
                .writingProduction(LanguageLevelMapper.mapToEntity(dto.getWritingProduction()))
                .build();
    }
}
