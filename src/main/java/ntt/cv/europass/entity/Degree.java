package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "Degree")
@Data
@Builder
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @OneToOne(mappedBy = "degree")
    private Education education;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;
}