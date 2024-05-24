package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="education")
@Data
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @ManyToMany(mappedBy = "educations",fetch = FetchType.EAGER)
    private List<Resume> resumes = new ArrayList<>();

}