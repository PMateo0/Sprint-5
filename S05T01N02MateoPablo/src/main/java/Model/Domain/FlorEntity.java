package Model.Domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "flor")
public class FlorEntity {

    @Id
    @GeneratedValue
    private Integer pk_FlorID;

    @Column(name = "name")
    private String name;

    @Column (name = "country")
    private String country;
}