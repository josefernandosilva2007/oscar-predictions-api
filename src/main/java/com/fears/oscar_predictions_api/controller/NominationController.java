package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.NominationDTO;
import com.fears.oscar_predictions_api.service.NominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
