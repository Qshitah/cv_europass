package ntt.cv.europass.service;


import ntt.cv.europass.entity.Skill;
import ntt.cv.europass.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService extends MainService<Skill, Long> {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository repository, SkillRepository skillRepository) {
        super(repository);
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> saveMultiple(List<Skill> entities) {
        List<Skill> skills = new ArrayList<>();
        for (Skill skill: entities){
            Skill skillExist = skillRepository.findByDescription(skill.getDescription());
            if(skillExist != null){
                skills.add(skillExist);
            }else {
                skills.add(skill);
                skillRepository.save(skill);
            }
        }
        return skills;
    }
}