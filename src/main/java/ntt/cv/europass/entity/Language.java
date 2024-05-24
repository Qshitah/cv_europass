package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Language")
@Data
@Builder
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_code")
    private String languageCode;

    @OneToMany(mappedBy = "language",fetch = FetchType.EAGER)
    private List<LanguageProficiency> languageProficiencies = new ArrayList<>();

}