package ntt.cv.europass.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private List<ExperienceDTO> experiences;
}
