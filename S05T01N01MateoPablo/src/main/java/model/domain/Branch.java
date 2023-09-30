package model.domain;

import jakarta.persistence.*;
import lombok.*;
;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table (name = "branch")
public class Branch {

    @Id
    @GeneratedValue
    private Integer pk_SucursalID;

    @Column (name = "name")
    private String name;

    @Column (name = "country")
    private String country;

}