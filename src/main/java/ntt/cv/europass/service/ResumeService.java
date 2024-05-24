package ntt.cv.europass.service;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ntt.cv.europass.dto.ResumeDTO;
import ntt.cv.europass.entity.*;
import ntt.cv.europass.mapper.ResumeMapper;
import ntt.cv.europass.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final AddressService addressService;
    private final LanguageService languageService;

    @Autowired
    private final ExperienceService experienceService;

    private final SkillService skillService;
    private final LanguageProficiencyService languageProficiencyService;
    private final CertificateService certificateService;
    private final CountryService countryService;
    private final EducationService educationService;

    public ResumeDTO parseResume(String json) throws Exception {
        //Using  ObjectMapper a powerful and flexible tool for converting between Java objects and JSON.
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());;

        //This line uses the readValue method of the ObjectMapper instance to convert the JSON string into a Java object.
        return objectMapper.readValue(json, ResumeDTO.class);
    }

    @Transactional
    public void saveResume(String json) throws Exception {
        ResumeDTO resumeDTO = parseResume(json);

        // Convert the ResumeDTO object into a Resume entity
        Resume resume = ResumeMapper.mapToEntity(resumeDTO);

        // Save the Resume entity along with its associated data
        Address address = addressService.save(resume.getAddress());
        resume.setAddress(address);

        Language language = languageService.save(resume.getPrimaryLanguage());
        resume.setPrimaryLanguage(language);

        List<Experience> experiences = experienceService.saveMultiple(resume.getExperiences());
        resume.setExperiences(experiences);

        List<Skill> skills = skillService.saveMultiple(resume.getSkills());
        resume.setSkills(skills);

        List<LanguageProficiency> languageProficiencies = languageProficiencyService.saveMultiple(resume.getLanguageProficiencies());
        resume.setLanguageProficiencies(languageProficiencies);

        List<Certificate> certificates =  certificateService.saveMultiple(resume.getCertificates());
        resume.setCertificates(certificates);

        //Nationalities
        List<Country> nationalities = countryService.saveMultiple(resume.getCountries());
        resume.setCountries(nationalities);

        List<Education> educations = educationService.saveMultiple(resume.getEducations());
        resume.setEducations(educations);

        // Save the Resume entity
        resumeRepository.save(resume);
    }


}
