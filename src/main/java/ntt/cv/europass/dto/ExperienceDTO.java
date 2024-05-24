package ntt.cv.europass.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExperienceDTO {
    private Long id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private CityDTO city;
    private ResumeDTO resume = null;
    private EmployerDTO employer;
    private ExperienceTypeDTO experienceType;
    private ClientDTO client;
    private ProjectDTO project;
}
