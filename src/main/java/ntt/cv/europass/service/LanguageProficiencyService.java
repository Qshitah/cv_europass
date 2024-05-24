package ntt.cv.europass.service;

import ntt.cv.europass.entity.Language;
import ntt.cv.europass.entity.LanguageProficiency;
import ntt.cv.europass.repository.LanguageProficiencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageProficiencyService extends MainService<LanguageProficiency, Long> {

    private final LanguageProficiencyRepository languageProficiencyRepository;
    private final LanguageService languageService;

    @Autowired
    public LanguageProficiencyService(LanguageProficiencyRepository repository, LanguageProficiencyRepository languageProficiencyRepository, LanguageService languageService) {
        super(repository);
        this.languageProficiencyRepository = languageProficiencyRepository;
        this.languageService = languageService;
    }

    @Override
    public List<LanguageProficiency> saveMultiple(List<LanguageProficiency> entities) {
        List<LanguageProficiency> languageProficiencies = new ArrayList<>();

        for (LanguageProficiency languageProficiency: entities){
            Language language = languageService.save(languageProficiency.getLanguage());
            languageProficiency.setLanguage(language);

            languageProficiencyRepository.save(languageProficiency);
            languageProficiencies.add(languageProficiency);
        }

        return languageProficiencies;
    }
}