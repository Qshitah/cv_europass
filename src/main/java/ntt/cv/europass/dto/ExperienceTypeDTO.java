package ntt.cv.europass.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExperienceTypeDTO {
    private Long id;
    private String name;
    private List<ExperienceDTO> experiences = new ArrayList<>();
}
