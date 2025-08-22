package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.UserDTO;
import com.fears.oscar_predictions_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
}
