package com.linga.userservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}