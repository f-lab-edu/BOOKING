package org.service.booking.adapters.in.web;

import lombok.Getter;
import org.service.booking.application.service.RestaurantService;
import org.service.booking.application.service.TableService;
import org.service.booking.domain.model.Table;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/restaurants/{restaurantId}/tables")
@RestController
public class TableController {
    private final TableService tableService;

    public TableController(RestaurantService restaurantService, TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public Table createTable(@PathVariable Long restaurantId, @RequestBody TableCreateRequest request) {
        return tableService.createTable(restaurantId, request.getCapacity(), request.isAvailable());
    }
}

@Getter
class TableCreateRequest {
    private int capacity;
    private boolean available;
}