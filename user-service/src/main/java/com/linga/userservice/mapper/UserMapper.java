package com.linga.userservice.mapper;

import com.linga.userservice.dto.UserDto;
import com.linga.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto mapUserToUserDto(User user);
    User mapUserDtoToUser(UserDto userDto);
}
