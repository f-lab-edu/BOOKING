package org.service.booking.adapters.out.persistence;

import lombok.RequiredArgsConstructor;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Repository;
import org.service.booking.application.exception.ResourceNotFoundException;
import org.service.booking.domain.model.Restaurant;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TableRepositoryAdapter implements TableRepositoryPort {

    private final JpaTableRepository jpaTableRepository;
    private final JpaRestaurantRepository jpaRestaurantRepository;
    
    @Override
    public Table save(Table table) {
        TableEntity tableEntity = TableEntity.fromDomain(table);

        RestaurantEntity restaurantEntity = jpaRestaurantRepository.findById(table.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + table.getRestaurantId()));
        tableEntity.setRestaurant(restaurantEntity);

        TableEntity savedEntity = jpaTableRepository.save(tableEntity);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Table> findById(Long id) {
        return jpaTableRepository.findById(id)
                .map(TableEntity::toDomain);
    }
}