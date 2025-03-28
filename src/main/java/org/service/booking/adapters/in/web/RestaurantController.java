package org.service.booking.adapters.in.web;

import org.service.booking.application.service.RestaurantService;
import org.service.booking.domain.model.Restaurant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant registerRestaurant(@RequestBody RestaurantRegistrationRequest request) {
        return restaurantService.registerRestaurant(request.toDomain());
    }
}