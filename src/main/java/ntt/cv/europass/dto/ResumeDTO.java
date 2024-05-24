package ntt.cv.europass.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResumeDTO {
    private Long id;
    private String givenName;
    private String familyName;
    private String formattedName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
    private LanguageDTO primaryLanguage;
    private List<ExperienceDTO> experiences = new ArrayList<>();
    private List<SkillDTO> skills = new ArrayList<>();
    private List<LanguageProficiencyDTO> languageProficiencies = new ArrayList<>();
    private List<CertificateDTO> certificates = new ArrayList<>();
    private List<CountryDTO> countries = new ArrayList<>();
    private List<EducationDTO> educations = new ArrayList<>();
}
