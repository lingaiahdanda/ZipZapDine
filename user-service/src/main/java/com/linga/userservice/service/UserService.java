package com.linga.userservice.service;

import com.linga.userservice.dto.UserDto;
import com.linga.userservice.entity.User;
import com.linga.userservice.mapper.UserMapper;
import com.linga.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public  List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return  users.stream().map(UserMapper.INSTANCE::mapUserToUserDto).toList();
    }

    public ResponseEntity<?> getUserById(int userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
             UserDto userDto = UserMapper.INSTANCE.mapUserToUserDto(user.get());
             return  new ResponseEntity<>(userDto, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }
    public UserDto addUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);
        return UserMapper.INSTANCE.mapUserToUserDto(userRepository.save(user));
    }
}
