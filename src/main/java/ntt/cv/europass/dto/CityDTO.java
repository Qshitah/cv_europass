package ntt.cv.europass.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CityDTO {
    private Long id;
    private String name;
    private CountryDTO country;
    private List<AddressDTO> addresses = new ArrayList<>();
    private List<ExperienceDTO> experiences = new ArrayList<>();
    private List<InstitutionDTO> institutions = new ArrayList<>();
}

