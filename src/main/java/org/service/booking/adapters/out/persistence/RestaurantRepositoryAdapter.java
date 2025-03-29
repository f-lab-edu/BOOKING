package org.service.booking.adapters.out.persistence;

import lombok.RequiredArgsConstructor;
import org.service.booking.domain.model.Restaurant;
import org.service.booking.domain.repository.RestaurantRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryAdapter implements RestaurantRepositoryPort {

    private final JpaRestaurantRepository jpaRestaurantRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        RestaurantEntity entity = RestaurantEntity.fromDomain(restaurant);
        RestaurantEntity saved = jpaRestaurantRepository.save(entity);
        return saved.toDomain();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return jpaRestaurantRepository.findById(id)
                .map(this::toDomain);
    }

    private Restaurant toDomain(RestaurantEntity entity){
        return new Restaurant(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getOpenTime(),
                entity.getCloseTime(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}