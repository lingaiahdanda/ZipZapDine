package com.linga.restaurantlisting.repository;

import com.linga.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo  extends JpaRepository<Restaurant , Integer> {

}
