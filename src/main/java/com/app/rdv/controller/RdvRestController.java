package com.app.rdv.controller;

import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Rdv;
import com.app.rdv.service.IServiceRdv;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rdv/")
@AllArgsConstructor
public class RdvRestController {
    private IServiceRdv iServiceRdv;

    @GetMapping
    public List<Rdv> findAll() {
        return iServiceRdv.getAllRdv();
    }

    @PostMapping("add")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rdv created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Rdv.class))),
            @ApiResponse(responseCode = "409", description = "Rdv not created",
            content = @Content(mediaType = "text/plain", schema = @Schema(type = "string")))
    })
    public ResponseEntity<?> add(@RequestBody Rdv rdv) {
        Rdv rdv1 = iServiceRdv.ajoutRdv(rdv);

        if (rdv1 != null)
            return  new ResponseEntity<>(rdv1, HttpStatus.CREATED);
        else
            return  new ResponseEntity<>("le Rdv n'a pas été ajouté",HttpStatus.CONFLICT);
    }

}
