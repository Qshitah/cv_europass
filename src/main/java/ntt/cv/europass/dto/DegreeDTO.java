package ntt.cv.europass.dto;

import lombok.Data;

@Data
public class DegreeDTO {
    private Long id;
    private String title;
    private InstitutionDTO institution;
    private SectorDTO sector;
}
