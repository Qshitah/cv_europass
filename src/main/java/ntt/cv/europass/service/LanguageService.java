package ntt.cv.europass.service;

import ntt.cv.europass.entity.Language;
import ntt.cv.europass.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService extends MainService<Language, Long> {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository repository, LanguageRepository languageRepository) {
        super(repository);
        this.languageRepository = languageRepository;
    }

    @Override
    public Language save(Language entity) {
        if(entity == null){
            return  null;
        }
        Language languageExist = languageRepository.findByLanguageCode(entity.getLanguageCode());

        if(languageExist != null){
            return languageExist;
        }else {
            return super.save(entity);
        }
    }
}
