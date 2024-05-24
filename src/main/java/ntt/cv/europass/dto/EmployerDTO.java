package ntt.cv.europass.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployerDTO {
    private Long id;
    private String name;
    private List<ExperienceDTO> experiences = new ArrayList<>(); // Optional: If you need to include associated experiences
}
