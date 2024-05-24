package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Certificate")
@Data
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name ;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "certificates",fetch = FetchType.EAGER)
    private List<Resume> resumes = new ArrayList<>();
}