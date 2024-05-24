package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Resume")
@Data
@Builder
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "formatted_name")
    private String formattedName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "primary_language_id")
    private Language primaryLanguage;

    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "resume")
    private List<LanguageProficiency> languageProficiencies = new ArrayList<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "resume_id"))
    private List<Certificate> certificates = new ArrayList<>();

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "resume_id"))
    private List<Country> countries = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Resume_educations",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "educations_id"))
    private List<Education> educations = new ArrayList<>();

}