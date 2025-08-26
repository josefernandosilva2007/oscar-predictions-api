package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.NominationDTO;
import com.fears.oscar_predictions_api.dto.NomineeDTO;
import com.fears.oscar_predictions_api.service.NominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nomination")
public class NominationController {
    @Autowired
    private NominationService nominationService;

    @GetMapping
    public ResponseEntity<List<NominationDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(nominationService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NominationDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(nominationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NominationDTO> saveNomination(@RequestBody NominationDTO entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(nominationService.saveNomination(entity));
    }
}
