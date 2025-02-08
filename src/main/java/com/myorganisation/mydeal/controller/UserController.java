package com.myorganisation.mydeal.controller;

import com.myorganisation.mydeal.dto.UserInputDto;
import com.myorganisation.mydeal.dto.UserOutputDto;
import com.myorganisation.mydeal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserOutputDto> addUser(@RequestBody UserInputDto userInputDto) {
        return new ResponseEntity<>(userService.addUser(userInputDto), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping
    public ResponseEntity<String> removeUser(@RequestParam Long id) {
        return new ResponseEntity<>(userService.removeUser(id), HttpStatusCode.valueOf(200));
    }
}
