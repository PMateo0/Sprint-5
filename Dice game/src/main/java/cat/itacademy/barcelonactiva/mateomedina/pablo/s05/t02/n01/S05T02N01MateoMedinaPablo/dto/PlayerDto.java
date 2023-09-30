package cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Long playerId;

    private String name;
}
