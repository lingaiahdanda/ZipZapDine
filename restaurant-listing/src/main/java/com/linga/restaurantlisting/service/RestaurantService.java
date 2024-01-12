package com.linga.restaurantlisting.service;

import com.linga.restaurantlisting.dto.RestaurantDTO;
import com.linga.restaurantlisting.entity.Restaurant;
import com.linga.restaurantlisting.mapper.RestaurantMapper;
import com.linga.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;


    public List<RestaurantDTO> fetchAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
                .collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant addedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(addedRestaurant);
    }

    public ResponseEntity<?> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
       if(restaurant.isPresent()){
           return new ResponseEntity<RestaurantDTO>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
       }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
