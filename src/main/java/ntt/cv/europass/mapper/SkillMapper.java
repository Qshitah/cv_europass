package ntt.cv.europass.mapper;

import ntt.cv.europass.dto.SkillDTO;
import ntt.cv.europass.entity.Resume;
import ntt.cv.europass.entity.Skill;

public class SkillMapper {

    public static Skill mapToEntity(SkillDTO skillDTO) {
        if (skillDTO == null) {
            return null;
        }

        return Skill.builder()
                .id(skillDTO.getId())
                .description(skillDTO.getDescription())
                .build();
    }
}

