package ntt.cv.europass.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CountryDTO {
    private Long id;
    private String name;
    private List<CityDTO> cities = new ArrayList<>();
    private List<ResumeDTO> resumes = new ArrayList<>();
}
