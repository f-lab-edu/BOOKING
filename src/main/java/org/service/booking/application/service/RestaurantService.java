package org.service.booking.application.service;

import org.service.booking.domain.model.Restaurant;
import org.service.booking.domain.repository.RestaurantRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepositoryPort restaurantRepositoryPort;

    public RestaurantService(RestaurantRepositoryPort restaurantRepositoryPort) {
        this.restaurantRepositoryPort = restaurantRepositoryPort;
    }

    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepositoryPort.save(restaurant);
    }

    public Restaurant findById(Long id) {
        return restaurantRepositoryPort.findById(id).orElse(null);
    }
}