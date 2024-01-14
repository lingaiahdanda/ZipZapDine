package com.linga.userservice.controller;

import com.linga.userservice.dto.UserDto;
import com.linga.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto user =  userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return  new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Integer userId){
        if (userId == null || userId <= 0) {
            return new ResponseEntity<>("Invalid user ID", HttpStatus.BAD_REQUEST);
        }
        return userService.getUserById(userId);
    }
}
