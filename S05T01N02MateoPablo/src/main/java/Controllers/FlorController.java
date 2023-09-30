package Controllers;

import Model.Dto.FlorDTO;
import Model.Services.FlorServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flor")

public class
FlorController {

    @Autowired
    FlorServices florServices;


    @PostMapping({"/add"})
    @Operation(
            tags="POST",
            operationId="ADD",
            summary = "Add new flowers",
            description = "Add a required flower and parameter",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Description",
                    content = @Content(schema = @Schema(implementation = FlorDTO.class)))
    )
    public ResponseEntity<String> saveFlor(@RequestBody FlorDTO florDto) {
        try {
            florServices.save(florDto);
            return ResponseEntity.ok("Flower saved.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save.");
        }
    };



    @PutMapping({"/update"})
    @Operation(
            tags="UPDATE",
            summary = "update",
            description = "update flower, add a required flower and parameter",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Description",
                    content = @Content(schema = @Schema(implementation = FlorDTO.class)))

    )
    public ResponseEntity<String> updateFlor(
            @RequestBody FlorDTO flowerDto) {
        try {
            florServices.update(flowerDto);
            return ResponseEntity.ok("Flower updated.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update flower: " + e.getMessage());
        }
    };

    @DeleteMapping("/delete/{id}")
    @Operation(
            tags="DELETE",
            summary = "delete",
            description = "write the id to delete"
    )

    public ResponseEntity<String> deleteFlor(@PathVariable Integer id) {
        try {
            florServices.delete(id);
            return ResponseEntity.ok("Flower deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete flower: " + e.getMessage());
        }
    };

    @GetMapping("/getOne/{id}")
    @Operation(
            tags="GETONE",
            summary = "get one flower",
            description = "write the id to get flower"
    )
    public ResponseEntity<FlorDTO> getFlor(@PathVariable Integer id) {
        FlorDTO flowerDto = florServices.getOne(id);
        if (flowerDto != null) {
            return new ResponseEntity<>(flowerDto,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };



    @GetMapping({"/getAll"})
    @Operation(
            tags="GETALL",
            summary = "get all flowers",
            description = "see all of them"
    )
    public ResponseEntity<List<FlorDTO>> getAllFlor(){
        List<FlorDTO> flowerDTO = florServices.getAll();
        if (!flowerDTO.isEmpty()) {
            return new ResponseEntity<>(flowerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

}