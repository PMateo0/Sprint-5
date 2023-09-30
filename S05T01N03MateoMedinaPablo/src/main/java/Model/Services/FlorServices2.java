package Model.Services;

import Model.Dto.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static Model.Constants.FlorConstants.*;

@Service
public class FlorServices2 implements IFlorServices2{

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<Void> save(FlorDTO florDTO) {
        return webClient.post()
                .uri(ADD_ONE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(florDTO), FlorDTO.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<Void> update(FlorDTO florDTO) {
        return webClient.put()
                .uri(UPDATE_ONE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(florDTO), FlorDTO.class)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<FlorDTO> getOne(Integer id) {
        return webClient.get().uri(GET_ONE+id)
                .retrieve()
                .bodyToMono(FlorDTO.class);
    }

    @Override
    public Flux<FlorDTO> getAll() {
        return webClient.get()
                .uri(GET_ALL_EMPLOYEES)
                .retrieve()
                .bodyToFlux(FlorDTO.class);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return webClient.delete()
                .uri(DELETE_ONE+1)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
