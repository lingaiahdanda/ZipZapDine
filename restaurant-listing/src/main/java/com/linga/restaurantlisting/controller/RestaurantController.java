package com.linga.restaurantlisting.controller;

import com.linga.restaurantlisting.dto.RestaurantDTO;
import com.linga.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
        List<RestaurantDTO> restaurants = restaurantService.fetchAllRestaurants();
        return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO newRestaurant = restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<RestaurantDTO>(newRestaurant,HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurant/{id}/")
    public ResponseEntity<?> findRestaurant(@PathVariable Integer id){
        return restaurantService.fetchRestaurantById(id);
    }
}
