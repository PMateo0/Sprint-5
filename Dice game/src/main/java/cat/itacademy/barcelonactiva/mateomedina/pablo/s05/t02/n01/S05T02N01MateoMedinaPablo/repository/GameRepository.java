package cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.repository;


import cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository <Game, Long> {

    public List<Game> findAllByPlayerId(Long playerId) ;
}
