package org.service.booking.domain.repository;

import org.service.booking.domain.model.Restaurant;

import java.util.Optional;

public interface RestaurantRepositoryPort {
    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Long id);
}
