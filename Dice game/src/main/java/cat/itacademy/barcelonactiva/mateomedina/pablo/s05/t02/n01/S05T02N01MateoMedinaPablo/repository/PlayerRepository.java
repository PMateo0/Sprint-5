package cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.repository;

import cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Long> {
}
