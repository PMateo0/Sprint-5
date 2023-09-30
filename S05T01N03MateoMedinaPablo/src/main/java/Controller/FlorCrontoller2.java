package Controller;

import Model.Dto.FlorDTO;
import Model.Services.FlorServices2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flor")
public class FlorCrontoller2 {

    @Autowired
    private FlorServices2 florservice2;

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags="POST",
            operationId="ADD",
            summary = "Add new flowers",
            description = "Add a required flower and parameter",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Description",
                    content = @Content(schema = @Schema(implementation = FlorDTO.class)))
    )
    public ResponseEntity<Mono<Void>> saveFlor(@RequestBody FlorDTO florDto) {
        try {
            Mono<Void> flowerDtoAdded = florservice2.save(florDto);
            return new ResponseEntity<>(flowerDtoAdded, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(value = "/update/", consumes =  MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags="UPDATE",
            summary = "update",
            description = "update flower, add a required flower and parameter",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Description",
                    content = @Content(schema = @Schema(implementation = FlorDTO.class)))

    )
    public ResponseEntity<Mono<Void>> updateFlor(
            @RequestBody FlorDTO flowerDto) {
        try {
            Mono<Void> flowerDtoUpdated = florservice2.update(flowerDto);
            return new ResponseEntity<>(flowerDtoUpdated,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @DeleteMapping(value="/delete/{id}")
    @Operation(
            tags="DELETE",
            summary = "delete",
            description = "write the id to delete"
    )

    public ResponseEntity<Mono<Void>>deleteFlor(@PathVariable Integer id) {
        try {
            Mono<Void> florDtoDeleted = florservice2.delete(id); // Wait for the deletion to complete
            return new ResponseEntity<>(florDtoDeleted,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };


    @GetMapping("/getOne/{id}")
    @Operation(
            tags="GETONE",
            summary = "get one flower",
            description = "write the id to get flower"
    )
    public ResponseEntity<Mono<FlorDTO>>getFlor(@PathVariable Integer id) {
        Mono<FlorDTO> florDto = florservice2.getOne(id);
        if (florDto != null) {
            return new ResponseEntity<>(florDto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };


    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            tags="GETALL",
            summary = "get all flowers",
            description = "see all of them"
    )
    public ResponseEntity<Flux<FlorDTO>> getAllFlor(){
        Flux<FlorDTO> florDtos = florservice2.getAll();
        if (florDtos!=null) {
            return new ResponseEntity<>(florDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };


}
