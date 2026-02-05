package entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_company;

    @Column(name = "codigo_company", length = 10, nullable = false, unique = true)
    private String codigoCompany;

    @Column(name = "name_company", length = 50, nullable = false)
    private String nameCompany;

    @Column(name = "description_company", length = 150, nullable = false)
    private String descriptionCompany;
}
