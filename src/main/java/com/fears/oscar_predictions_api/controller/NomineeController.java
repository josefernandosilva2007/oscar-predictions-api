package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.NomineeDTO;
import com.fears.oscar_predictions_api.entity.Nominee;
import com.fears.oscar_predictions_api.service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nominee")
public class NomineeController {
    @Autowired
    private NomineeService nomineeService;

    @GetMapping
    public ResponseEntity<List<NomineeDTO>> findAllNominee(){
        return ResponseEntity.status(HttpStatus.OK).body(nomineeService.findAll());
    }

    @PostMapping
    public ResponseEntity<NomineeDTO> saveNominee(@RequestBody NomineeDTO entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(nomineeService.saveNominee(entity));
    }
}
