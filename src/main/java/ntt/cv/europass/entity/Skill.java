package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Skill")
@Data
@Entity
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}