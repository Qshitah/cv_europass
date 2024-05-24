package ntt.cv.europass.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data

public class EducationDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private DegreeDTO degree;
    private List<ResumeDTO> resumes = new ArrayList<>();
}
