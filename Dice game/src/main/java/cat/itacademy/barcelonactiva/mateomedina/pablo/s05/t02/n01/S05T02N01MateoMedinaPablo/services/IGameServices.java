package cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.services;



import cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.domain.Game;
import cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.dto.GameDto;
import cat.itacademy.barcelonactiva.mateomedina.pablo.s05.t02.n01.S05T02N01MateoMedinaPablo.dto.PlayerDto;

import java.util.List;
import java.util.Optional;

public interface IGameServices {
    void create(PlayerDto playerDto);
    void update(PlayerDto playerDto);
    PlayerDto findPlayerById(Long id);
    GameDto createGame(Long id);
    void deleteGamesByPlayerId(Long id);
    List<PlayerDto> findAllPlayers();
    Optional<List<Game>> findGamesByPlayerId(Long id);
    List<GameDto> rankingAll();
    List<String> calculatePlayersRank();
    String rankingLooser();
    String rankingWinner();

}
