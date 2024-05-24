package ntt.cv.europass.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "address")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_description")
    private String addressDescription;

    @Column(name = "postal_code")
    private Integer postalCode;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;
}