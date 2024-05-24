package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Country")
@Data
@Builder
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country",fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<>();

    @ManyToMany(mappedBy = "countries",fetch = FetchType.EAGER)
    private List<Resume> resumes = new ArrayList<>();

}