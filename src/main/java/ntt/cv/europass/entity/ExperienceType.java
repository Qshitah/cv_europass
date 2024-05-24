package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Experience_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExperienceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "experienceType",fetch = FetchType.EAGER)
    private List<Experience> experiences = new ArrayList<>();

}