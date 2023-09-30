package cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
}
