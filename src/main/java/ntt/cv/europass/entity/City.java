package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "City")
@Data
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<Institution> institutions = new ArrayList<>();

}