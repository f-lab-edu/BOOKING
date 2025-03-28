package org.service.booking.application.service;

import org.service.booking.domain.model.Restaurant;
import org.service.booking.domain.model.Table;
import org.service.booking.domain.repository.RestaurantRepositoryPort;
import org.service.booking.domain.repository.TableRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    private final TableRepositoryPort tableRepositoryPort;

    public TableService(RestaurantRepositoryPort restaurantRepositoryPort, TableRepositoryPort tableRepositoryPort) {
        this.tableRepositoryPort = tableRepositoryPort;
    }

    public Table createTable(Long restaurantId, int capacity, boolean isAvailable) {
        Table table = new Table(null, restaurantId, capacity, isAvailable);
        return tableRepositoryPort.save(table);
    }
}