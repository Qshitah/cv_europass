package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.ResumeDTO;
import ntt.cv.europass.entity.Resume;

import java.util.stream.Collectors;

public class ResumeMapper {

    public static Resume mapToEntity(ResumeDTO dto) {
        if (dto == null) {
            return null;
        }

        return Resume.builder()
                .id(dto.getId())
                .givenName(dto.getGivenName())
                .familyName(dto.getFamilyName())
                .formattedName(dto.getFormattedName())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(AddressMapper.mapToEntity(dto.getAddress()))
                .primaryLanguage(LanguageMapper.mapToEntity(dto.getPrimaryLanguage()))
                .experiences(dto.getExperiences().stream()
                        .map(ExperienceMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .skills(dto.getSkills().stream()
                        .map(SkillMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .languageProficiencies(dto.getLanguageProficiencies().stream()
                        .map(LanguageProficiencyMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .certificates(dto.getCertificates().stream()
                        .map(CertificateMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .countries(dto.getCountries().stream()
                        .map(CountryMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .educations(dto.getEducations().stream()
                        .map(EducationMapper::mapToEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
