package com.linga.restaurantlisting.mapper;

import com.linga.restaurantlisting.dto.RestaurantDTO;
import com.linga.restaurantlisting.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    //to map restaurant to  restaurantDTO
    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

    //to map restaurantDTO to  restaurant
    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
}
