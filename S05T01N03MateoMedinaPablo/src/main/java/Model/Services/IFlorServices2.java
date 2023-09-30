package Model.Services;
import Model.Dto.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface IFlorServices2 {
    Mono<Void> save(FlorDTO flowerDto);

    Mono <Void> update(FlorDTO flowerDto);

    Mono<FlorDTO> getOne(Integer id);
    Flux<FlorDTO> getAll();

    Mono <Void> delete(Integer id);


}