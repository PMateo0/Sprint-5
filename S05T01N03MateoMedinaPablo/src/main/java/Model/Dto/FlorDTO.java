package Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlorDTO {

    private Integer pk_FlorID;

    private String name;

    private String country;

    private String type;


    public FlorDTO(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void setCountry(String country) {
        List<String> countries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic",
                "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta",
                "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));
        this.country = country;
        this.type = countries.stream().anyMatch(type -> type.equalsIgnoreCase(country)) ? "UE" : "Not UE";
    }
}