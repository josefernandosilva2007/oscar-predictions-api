package com.fears.oscar_predictions_api.controller;


import com.fears.oscar_predictions_api.dto.UserDTO;
import com.fears.oscar_predictions_api.entity.User;
import com.fears.oscar_predictions_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> saveNewUser(@RequestBody User entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveNewUser(entity));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByID(id));
    }
}
